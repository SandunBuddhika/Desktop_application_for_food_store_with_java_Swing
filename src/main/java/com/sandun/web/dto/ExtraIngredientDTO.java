package com.sandun.web.dto;

import java.util.HashMap;
import java.util.Map;

public class ExtraIngredientDTO {

    private long id;
    private String name;
    private double price;
    private static final Map<Long, ExtraIngredientDTO> EXTRA_INGREDIENT_POOL = new HashMap<>();

    private ExtraIngredientDTO(long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public static class Builder {

        private long id;
        private String name;
        private double price;

        public Builder setId(long id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public ExtraIngredientDTO build() {
            ExtraIngredientDTO dto = EXTRA_INGREDIENT_POOL.get(this.id);
            if (dto == null) {
                dto = new ExtraIngredientDTO(id, name, price);
                EXTRA_INGREDIENT_POOL.put(this.id, dto);
            }
            return dto;
        }

    }

    @Override
    public String toString() {
        return "ExtraIngredentDTO{" + "id=" + id + ", name=" + name + '}';
    }

}
