package com.sandun.web.model;

import com.sandun.web.dto.ExtraIngredientDTO;

public interface Expression {

    public ExtraIngredientDTO.Builder interpret();
}
