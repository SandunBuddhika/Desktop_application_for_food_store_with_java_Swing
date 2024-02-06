package com.sandun.web.model;

import com.sandun.web.entities.enums.OrderState;
import com.sandun.web.service.OrderService;
import javax.swing.JOptionPane;
import com.sandun.web.model.OrderManagement;

public class PackingHandler extends HandleComponent {

    @Override
    public void handle(OrderManagement orderManagement) {
        if (nextHandler != null) {
            OrderService service = new OrderService();
            boolean isFinish = service.changeTheOrderState(orderManagement.getCurrectOrder().getId(), OrderState.PACKING);
            if (isFinish) {
                System.out.println("Packing Process is Done");
                nextHandler.handle(orderManagement);
            } else {
                JOptionPane.showMessageDialog(orderManagement.getOrderManagement(), "You Couldn't able pack the order", "WARING", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

}
