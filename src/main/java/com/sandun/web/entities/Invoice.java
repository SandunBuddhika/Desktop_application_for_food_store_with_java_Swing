package com.sandun.web.entities;

import com.sandun.web.entities.enums.OrderState;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import java.util.Date;
import java.util.List;

@Entity
@NamedQueries({
    @NamedQuery(name = "getOrdersByUserId", query = "select i from Invoice i where i.user.id =: uId"),
    @NamedQuery(name = "getAllInvoices", query = "select  i from Invoice i inner join fetch i.items"),
    @NamedQuery(name = "getInvoiceById", query = "select  i from Invoice i where i.id=:iId")
})
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Double total;
    @Column(nullable = false)
    private Date date;
    @OneToMany(mappedBy = "invoice", cascade = CascadeType.PERSIST)
    private List<InvoiceItem> items;
    @ManyToOne
    private User user;
    @OneToOne(mappedBy = "order")
    @PrimaryKeyJoinColumn
    private OrderManager handler;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<InvoiceItem> getItems() {
        return items;
    }

    public void setItems(List<InvoiceItem> items) {
        this.items = items;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public OrderManager getHandler() {
        return handler;
    }

    public void setHandler(OrderManager handler) {
        this.handler = handler;
    }

}
