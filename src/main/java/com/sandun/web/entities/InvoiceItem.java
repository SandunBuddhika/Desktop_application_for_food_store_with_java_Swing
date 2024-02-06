package com.sandun.web.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import java.util.HashSet;
import java.util.Set;

@Entity
@NamedQueries({
    @NamedQuery(name = "getInvoiceItemByInvoiceId", query = "select ii from InvoiceItem ii where ii.invoice.id=:IId")
})
public class InvoiceItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Food food;
    @Column(nullable = false)
    private Integer qty;
    @ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinTable(name = "invoice_has_ingredient", joinColumns = @JoinColumn(name = "invoice_id"), inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
    private Set<ExtraIngredient> invoiceIngredients = new HashSet<>();
    @ManyToOne
    @JoinColumn(nullable = false)
    private Invoice invoice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Set<ExtraIngredient> getInvoiceIngredients() {
        return invoiceIngredients;
    }

    public void setInvoiceIngredients(Set<ExtraIngredient> invoiceIngredients) {
        this.invoiceIngredients = invoiceIngredients;
    }

}
