package com.sandun.web.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQuery;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@NamedQuery(name = "getCustomIngredient",query = "select e from ExtraIngredient e where e.name like : eName and e.price=:ePrice")
public class ExtraIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Double price;
    @ManyToMany(mappedBy = "ingredients", cascade = CascadeType.PERSIST)
    private Set<Food> foodList = new HashSet<>();
    @ManyToMany(mappedBy = "invoiceIngredients", cascade = CascadeType.MERGE)
    private Set<InvoiceItem> invoiceItems = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(Set<Food> foodList) {
        this.foodList = foodList;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Set<InvoiceItem> getInvoiceItems() {
        return invoiceItems;
    }

    public void setInvoiceItems(Set<InvoiceItem> invoiceItems) {
        this.invoiceItems = invoiceItems;
    }

}
