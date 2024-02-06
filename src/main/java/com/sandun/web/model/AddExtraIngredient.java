package com.sandun.web.model;

import com.sandun.web.dto.ExtraIngredientDTO;
import com.sandun.web.dto.FoodDTO;
import com.sandun.web.panel.OrderFood;
import java.util.Map;
import javax.swing.JOptionPane;

public class AddExtraIngredient {

    private Expression expression;
    private Map<Long, ExtraIngredientDTO> customIngregient;
    private OrderFood panel;

    public AddExtraIngredient(OrderFood panel, Expression expression, Map<Long, ExtraIngredientDTO> customIngregient) {
        this.expression = expression;
        this.customIngregient = customIngregient;
    }

    public void interpret() {
        if (expression != null && expression.interpret() != null) {
            ExtraIngredientDTO xi = expression.interpret().build();
            customIngregient.put(xi.getId(), xi);
            JOptionPane.showMessageDialog(panel, "Successfull add the " + xi.getName() + " to your Order!!", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(panel, "The custom code is invalid!!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }

}
