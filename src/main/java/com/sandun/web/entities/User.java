package com.sandun.web.entities;

import com.sandun.web.entities.enums.UserType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private Date date;
    private UserType type;
    @OneToMany(mappedBy = "user")
    private List<Invoice> invoices;
    @OneToMany(mappedBy = "handler")
    private List<OrderManager> orderHandlers;

    public User() {
    }

    public User(String username, String password, Date date, UserType type) {
        this.username = username;
        this.password = password;
        this.date = date;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }


    public List<OrderManager> getOrderHandlers() {
        return orderHandlers;
    }

    public void setOrderHandlers(List<OrderManager> orderHandlers) {
        this.orderHandlers = orderHandlers;
    }

}
