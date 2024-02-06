package com.sandun.web.model;

import com.sandun.web.dto.FoodDTO;
import com.sandun.web.panel.OrderFood;
import javax.swing.JOptionPane;

public class AddExtraIngredient {

    private Expression expression;
    private FoodDTO.Builder food;
    private OrderFood panel;

    public AddExtraIngredient(OrderFood panel, Expression expression, FoodDTO.Builder food) {
        this.expression = expression;
        this.food = food;
    }

    public void interpret() {
        if (food != null && expression != null && expression.interpret() != null) {
            food.addExtraIngredients(expression.interpret().build());
        } else {
            JOptionPane.showMessageDialog(panel, "The custom code is invalid!!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }

}
