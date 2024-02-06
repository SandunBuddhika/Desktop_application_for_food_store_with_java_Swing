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
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@NamedQueries({
    @NamedQuery(name = "getAll", query = "select f from Food f")
})
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String img;
    @Column(nullable = false)
    private Double price;
    @OneToMany(mappedBy = "food")
    private List<InvoiceItem> invoiceItems;
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name = "food_has_ingredients", joinColumns = @JoinColumn(name = "food_id"), inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
    private Set<ExtraIngredient> ingredients = new HashSet<>();

    public Food() {
    }

//    public Food(long id, String name, String description, String img, Double price, List<InvoiceItem> invoiceItems) {
//        this.id = id;
//        this.name = name;
//        this.description = description;
//        this.img = img;
//        this.price = price;
//        this.invoiceItems = invoiceItems;
//    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<InvoiceItem> getInvoiceItems() {
        return invoiceItems;
    }

    public void setInvoiceItems(List<InvoiceItem> invoiceItems) {
        this.invoiceItems = invoiceItems;
    }

    public Set<ExtraIngredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<ExtraIngredient> ingredients) {
        this.ingredients = ingredients;
    }

}
