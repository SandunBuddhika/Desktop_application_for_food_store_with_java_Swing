package com.sandun.web.model;

import com.sandun.web.dto.ExtraIngredientDTO;
import com.sandun.web.dto.FoodDTO;
import com.sandun.web.dto.OrderManagerDTO;
import com.sandun.web.entities.ExtraIngredient;
import com.sandun.web.entities.Food;
import com.sandun.web.entities.Invoice;
import com.sandun.web.entities.InvoiceItem;
import com.sandun.web.entities.OrderManager;
import com.sandun.web.entities.enums.OrderState;
import com.sandun.web.service.InvoiceService;
import com.sandun.web.service.OrderService;
import com.sandun.web.template.ChatOrderItem;
import com.sandun.web.template.FoodDetailsViewer;
import com.sandun.web.template.OrderItem;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class OrderManagement {

    private final InvoiceService invoiceService;
    private final ClickEffectManager cem;
    private final OrderService orderService;
    private OrderManagerDTO currectOrder;
    private final com.sandun.web.panel.OrderManagement orderManagement;
    private DefaultTableModel dtm;

    public OrderManagement(com.sandun.web.panel.OrderManagement orderManagement) {
        this.orderService = new OrderService();
        this.orderManagement = orderManagement;
        this.invoiceService = new InvoiceService();
        this.cem = new ClickEffectManager(new Color(204, 204, 204), new Color(153, 153, 153));
        dtm = (DefaultTableModel) orderManagement.jTable1.getModel();
    }

    public void takeTheOrder(long invoiceId) {
        orderService.takeTheOrder(invoiceId);
        JOptionPane.showMessageDialog(orderManagement, "You Took the order No: " + invoiceId + ".", "INFO", JOptionPane.INFORMATION_MESSAGE);
        loadOrders();
        loadHandilingOrders();
        loadOrderHistory();
        reset();
        currectOrder = null;
    }

    public void handleTheOrder() {
        if (currectOrder != null) {
            CookingHandler handler1 = new CookingHandler();
            PackingHandler handler2 = new PackingHandler();
            DeliverHandler handler3 = new DeliverHandler();
            handler1.setNextHandler(handler2);
            handler2.setNextHandler(handler3);
            handler1.handle(this);
            loadOrders();
            loadHandilingOrders();
            loadOrderHistory();
            reset();
            currectOrder = null;
        } else {
            valitateErrorMessage();
        }
    }

    private void valitateErrorMessage() {
        JOptionPane.showMessageDialog(orderManagement, "Please select a order first", "WARNING", JOptionPane.WARNING_MESSAGE);
    }

    public OrderManagerDTO getCurrectOrder() {
        return currectOrder;
    }

    public void setCurrectOrder(OrderManagerDTO currectOrder) {
        this.currectOrder = currectOrder;
    }

    public com.sandun.web.panel.OrderManagement getOrderManagement() {
        return orderManagement;
    }

    public void loadOrders() {
        List<Invoice> invoices = invoiceService.getAllInvoice();
        orderManagement.jPanel1.removeAll();
        for (Invoice i : invoices) {
            if (i.getHandler() == null) {
                String name = i.getId() + " : ";
                for (InvoiceItem ii : i.getItems()) {
                    name += " " + ii.getFood().getName() + ",";
                }
                com.sandun.web.panel.OrderManagement om = orderManagement;
                ChatOrderItem item = new ChatOrderItem(name.substring(0, name.length() - 1), i.getId(), cem);
                item.getMyPanelRound4().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (e.getClickCount() == 2) {
                            if (JOptionPane.showConfirmDialog(om, "Do your want to take the order", "QUESTION", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                                takeTheOrder(i.getId());
                            }
                        }
                    }
                });
                orderManagement.jPanel1.add(item);
                orderManagement.jPanel1.add(Box.createVerticalStrut(5));
            }
        }
        orderManagement.jPanel1.revalidate();
        orderManagement.jPanel1.repaint();
    }

    public void loadHandilingOrders() {
        List<OrderManager> orders = orderService.getAllOrder();
        orderManagement.preparing_container.removeAll();
        ClickEffectManager handilingOrdersCem = new ClickEffectManager(new Color(204, 204, 204), new Color(153, 153, 153));
        for (OrderManager o : orders) {
            OrderManagerDTO.Builder b = new OrderManagerDTO.Builder().setId(o.getId()).setState(o.getState()).setInvoiceId(o.getOrder().getId()).setUserId(o.getHandler().getId()).setTotal(o.getOrder().getTotal());
            List<FoodDTO> fList = new ArrayList<>();
            for (InvoiceItem iItem : o.getOrder().getItems()) {
                Food f = iItem.getFood();
                Map<Long, ExtraIngredientDTO> extraIngredients = new HashMap<>();
                for (ExtraIngredient xi : iItem.getInvoiceIngredients()) {
                    extraIngredients.put(xi.getId(), new ExtraIngredientDTO.Builder().setId(xi.getId()).setName(xi.getName()).setPrice(xi.getPrice()).build());
                }
                FoodDTO dto = new FoodDTO.Builder().setDescription(f.getDescription()).setPath(f.getImg()).setId(f.getId()).setPrice(f.getPrice()).setQty(iItem.getQty()).setName(f.getName()).setExtraIngredients(extraIngredients).build();
                fList.add(dto);
            }
            b.setFood(fList);

            OrderItem item = new OrderItem(b.build(), handilingOrdersCem);
            switch (o.getState()) {
                case PREPARING: {
                    orderManagement.preparing_container.add(item);
                    orderManagement.preparing_container.add(Box.createHorizontalStrut(5));
                    break;
                }
            }
            orderManagement.preparing_container.revalidate();
            orderManagement.preparing_container.repaint();
            item.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    OrderManagerDTO omDto = item.getOrder();
                    setCurrectOrder(omDto);
                    addOrderDetails(omDto);
                }
            });
        }
    }

    public void addOrderDetails(OrderManagerDTO order) {
        orderManagement.orderIdLable.setText(String.valueOf(order.getId()));
        orderManagement.totalPriceLable.setText(String.valueOf(order.getTotal()));
        orderManagement.orderStateLable.setText(String.valueOf(order.getState()));
        List<FoodDTO> foods = order.getFood();
        orderManagement.orderDetailsContainer.removeAll();
        if (!foods.isEmpty()) {
            orderManagement.jLabel4.setVisible(true);
            orderManagement.orderDetailsContainer.setLayout(new BoxLayout(orderManagement.orderDetailsContainer, BoxLayout.Y_AXIS));
            ClickEffectManager orderDetailsCem = new ClickEffectManager(new Color(204, 204, 204), new Color(153, 153, 153));
            for (FoodDTO f : foods) {
                FoodDetailsViewer detailsViewer = new FoodDetailsViewer(f, orderDetailsCem);
                orderManagement.orderDetailsContainer.add(detailsViewer);
                orderManagement.orderDetailsContainer.add(Box.createVerticalStrut(5));
            }
        } else {
            orderManagement.jLabel4.setVisible(false);
        }
        orderManagement.orderDetailsContainer.revalidate();
        orderManagement.orderDetailsContainer.repaint();
    }

    public void loadOrderHistory() {

        List<OrderManager> oms = orderService.getAllOrders(OrderState.DELIVERED);
        System.out.println(dtm.getRowCount());
        removeAllTableData();
        System.out.println(dtm.getRowCount());
        int i = 1;
        for (OrderManager om : oms) {
            Vector<String> v = new Vector<>();
            v.add(String.valueOf(om.getId()));
            v.add(String.valueOf(om.getHandler()));
            v.add(String.valueOf(om.getState()));
            String fName = "";
            for (InvoiceItem ii : om.getOrder().getItems()) {
                fName += ii.getFood().getName() + ", ";
            }
            v.add(fName.substring(0, fName.length() - 2));
            v.add(String.valueOf(String.valueOf(om.getOrder().getTotal())));
            dtm.addRow(v);
            System.out.println("asdasdas");
        }
    }

    private void removeAllTableData() {
        int size = dtm.getRowCount();
        for (int i = size - 1; i >= 0; i--) {
            dtm.removeRow(i);
        }
    }

    public void reset() {
        orderManagement.orderIdLable.setText("None");
        orderManagement.totalPriceLable.setText("0.00");
        orderManagement.orderStateLable.setText("None");
        orderManagement.orderDetailsContainer.removeAll();
        orderManagement.jLabel4.setVisible(false);
        orderManagement.orderDetailsContainer.revalidate();
        orderManagement.orderDetailsContainer.repaint();
    }
}
