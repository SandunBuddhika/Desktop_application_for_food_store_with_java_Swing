package com.sandun.web.entities;

import com.sandun.web.entities.enums.OrderState;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.List;

@Entity
@NamedQueries({
    @NamedQuery(name = "getOrderhandlers", query = "select o from OrderManager o where o.order.user.id =:uId and o.state=:oState or o.handler.id =:uId and o.state=:oState"),
    @NamedQuery(name = "getAllOrders", query = "select distinct o from OrderManager o inner join fetch o.order.items where o.state=:oState"),
    @NamedQuery(name = "getAllOrdershandlers", query = "select o from OrderManager o inner join fetch o.order.items where o.state=0"),})
public class OrderManager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @MapsId
    private Invoice order;
    @ManyToOne
    private User handler;
    @OneToMany(mappedBy = "order")
    private List<Message> chat;
    @Column(nullable = false)
    private OrderState state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Invoice getOrder() {
        return order;
    }

    public void setOrder(Invoice order) {
        this.order = order;
    }

    public User getHandler() {
        return handler;
    }

    public void setHandler(User handler) {
        this.handler = handler;
    }

    public List<Message> getChat() {
        return chat;
    }

    public void setChat(List<Message> chat) {
        this.chat = chat;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

}
