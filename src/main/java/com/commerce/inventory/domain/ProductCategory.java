package com.commerce.inventory.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "ProductCategory")
@Table(name = "product_category")
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = Product.class, optional = false, fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(targetEntity = Category.class, optional = false, fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "category_id")
    private Category category;

    public ProductCategory() {
    }

    public ProductCategory(Category category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductCategory that = (ProductCategory) o;
        return Objects.equals(product, that.product) && Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, category);
    }
}
