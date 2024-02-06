package com.sandun.web.dto;

import com.sandun.web.entities.ExtraIngredient;
import com.sandun.web.entities.Food;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FoodDTO {

    private long id;
    private String name;
    private String path;
    private double price;
    private int qty;
    private String description;
    private List<ExtraIngredientDTO> extraIngredients;
    private static final Map<String, FoodDTO> FOOD_POOL = new HashMap<>();

    private FoodDTO(long id, String name, String path, double price, int qty, String description, List<ExtraIngredientDTO> extraIngredients) {
        this.id = id;
        this.name = name;
        this.path = path;
        this.price = price;
        this.qty = qty;
        this.description = description;
        this.extraIngredients = extraIngredients;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public int getQty() {
        return qty;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public List<ExtraIngredientDTO> getExtraIngredients() {
        return extraIngredients;
    }

    public static class Builder {

        private long id;
        private String name;
        private String path;
        private double price;
        private int qty;
        private String description;
        private Map<Long, ExtraIngredientDTO> extraIngredients;

        public Builder() {
            extraIngredients = new HashMap<>();
        }

        public Builder(Food f) {
            this.id = f.getId();
            this.name = f.getName();
            this.path = f.getImg();
            this.price = f.getPrice();
            this.description = f.getDescription();
            Set<ExtraIngredient> listE = f.getIngredients();
            if (listE != null && !listE.isEmpty()) {
                extraIngredients = new HashMap<>();
                for (ExtraIngredient e : listE) {
                    extraIngredients.put(e.getId(), new ExtraIngredientDTO.Builder().setId(e.getId()).setName(e.getName()).setPrice(e.getPrice()).build());
                }
            }
        }

        public Builder setId(long id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setPath(String path) {
            this.path = path;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder setQty(int qty) {
            this.qty = qty;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setExtraIngredients(Map<Long, ExtraIngredientDTO> extraIngredients) {
            this.extraIngredients = extraIngredients;
            return this;
        }

        public Builder addExtraIngredients(long id, ExtraIngredientDTO extraIngredient) {
            this.extraIngredients.put(id, extraIngredient);
            return this;
        }

        public FoodDTO build() {
            String key = this.toString();
            FoodDTO dto = FOOD_POOL.get(key);
            if (dto == null) {
                dto = new FoodDTO(id, name, path, price, qty, description, new ArrayList<>(extraIngredients.values()));
                FOOD_POOL.put(key, dto);
            }
            return dto;
        }

        @Override
        public String toString() {
            return "Builder{" + "name=" + name + ", path=" + path + ", price=" + price + ", qty=" + qty + ", description=" + description + ", extraIngredients=" + extraIngredients + '}';
        }

    }

    @Override
    public String toString() {
        return name;
    }

}
