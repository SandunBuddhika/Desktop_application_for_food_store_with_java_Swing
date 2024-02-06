package com.sandun.web.entities;

import com.sandun.web.entities.enums.MessageType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import java.util.Date;

@Entity
@NamedQueries({
    @NamedQuery(name = "loadChat", query = "select m from Message m where m.order.id=:oId"),
    @NamedQuery(name = "loadChatSize", query = "select count(m.id) from Message m where m.order.id=:oId")
})
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 450, nullable = false)
    private String message;
    @Column(nullable = false)
    private Date date;
    @Column(nullable = false)
    private MessageType type;
    @ManyToOne
    private OrderManager order;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }


    public OrderManager getOrder() {
        return order;
    }

    public void setOrder(OrderManager order) {
        this.order = order;
    }

   


}
