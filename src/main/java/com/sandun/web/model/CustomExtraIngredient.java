package com.sandun.web.model;

import com.sandun.web.dto.ExtraIngredientDTO;
import com.sandun.web.entities.ExtraIngredient;
import com.sandun.web.service.FoodService;

public class CustomExtraIngredient implements Expression {

    private String customCode;
    private FoodService service;

    public CustomExtraIngredient(String customCode) {
        this.customCode = customCode;
        this.service = new FoodService();
    }

    @Override
    public ExtraIngredientDTO.Builder interpret() {
        ExtraIngredientDTO.Builder builder = null;
        ExtraIngredient xi = service.getExtraIngredientByName(customCode.charAt(0), Double.valueOf(customCode.substring(1)));
        if (xi != null) {
            builder = new ExtraIngredientDTO.Builder().setId(xi.getId()).setName(xi.getName()).setPrice(xi.getPrice());
        }
        return builder;
    }

}
