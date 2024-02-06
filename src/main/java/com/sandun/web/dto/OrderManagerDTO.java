package com.sandun.web.dto;

import com.sandun.web.entities.enums.OrderState;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderManagerDTO {

    private long id;
    private long invoiceId;
    private long userId;
    private OrderState state;
    private List<FoodDTO> food;
    private double total;
    private static final Map<String, OrderManagerDTO> ORDER_MANAGER_POOL = new HashMap<>();

    public OrderManagerDTO(long id, long invoiceId, long userId, OrderState state, List<FoodDTO> food, double total) {
        this.id = id;
        this.invoiceId = invoiceId;
        this.userId = userId;
        this.state = state;
        this.food = food;
        this.total = total;
    }

    public long getId() {
        return id;
    }

    public long getInvoiceId() {
        return invoiceId;
    }

    public long getUserId() {
        return userId;
    }

    public OrderState getState() {
        return state;
    }

    public List<FoodDTO> getFood() {
        return food;
    }

    public double getTotal() {
        return total;
    }

    public static class Builder {

        private long id;
        private long invoiceId;
        private long userId;
        private OrderState state;
        private List<FoodDTO> food;
        private double total;

        public Builder setId(long id) {
            this.id = id;
            return this;
        }

        public Builder setInvoiceId(long invoiceId) {
            this.invoiceId = invoiceId;
            return this;
        }

        public Builder setUserId(long userId) {
            this.userId = userId;
            return this;
        }

        public Builder setState(OrderState state) {
            this.state = state;
            return this;
        }

        public Builder setFood(List<FoodDTO> food) {
            this.food = food;
            return this;
        }

        public Builder setTotal(double total) {
            this.total = total;
            return this;
        }

        public OrderManagerDTO build() {
            OrderManagerDTO dto = ORDER_MANAGER_POOL.get(toString());
            if (dto == null) {
                dto = new OrderManagerDTO(id, invoiceId, userId, state, food, total);
                ORDER_MANAGER_POOL.put(toString(), dto);
            }
            return dto;
        }

        @Override
        public String toString() {
            return "Builder{" + "id=" + id + ", invoiceId=" + invoiceId + ", userId=" + userId + ", state=" + state + ", food=" + food + ", total=" + total + '}';
        }

    }
}
