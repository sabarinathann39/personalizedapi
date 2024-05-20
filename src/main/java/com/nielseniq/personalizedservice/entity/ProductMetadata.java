package com.nielseniq.personalizedservice.entity;


import jakarta.persistence.*;


@Entity
@Table(name="cfg_product_metadata")
public class ProductMetadata {
    @Id
   // @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "product_id")
    private String productId;
    @Column(name = "category")
    private String category;
    @Column(name = "brand")

    private String brand;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
