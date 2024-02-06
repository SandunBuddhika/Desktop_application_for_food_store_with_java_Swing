package com.sandun.web.model;

import com.sandun.web.entities.enums.OrderState;
import com.sandun.web.service.OrderService;
import javax.swing.JOptionPane;

public class DeliverHandler extends HandleComponent {

    @Override
    public void handle(OrderManagement orderManagement) {
        OrderService service = new OrderService();
        boolean isFinish = service.changeTheOrderState(orderManagement.getCurrectOrder().getId(), OrderState.DELIVERED);
        if (isFinish) {
           JOptionPane.showMessageDialog(orderManagement.getOrderManagement(), "You Successfully delivered the food order!", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(orderManagement.getOrderManagement(), "You Couldn't able cook the order", "WARING", JOptionPane.WARNING_MESSAGE);
        }
    }

}
