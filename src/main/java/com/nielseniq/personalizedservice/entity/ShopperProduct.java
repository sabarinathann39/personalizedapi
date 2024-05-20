package com.nielseniq.personalizedservice.entity;



import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="txn_shopper_product")
public class ShopperProduct {
    @Id
   // @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")

    private String id;
    @Column(name = "shopper_id")

    private String shopperId;


    @Column(name = "product_id")
    private String productId;
    @Column(name = "relevancy_score")

    private Double relevancyScore;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShopperId() {
        return shopperId;
    }

    public void setShopperId(String shopperId) {
        this.shopperId = shopperId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Double getRelevancyScore() {
        return relevancyScore;
    }

    public void setRelevancyScore(Double relevancyScore) {
        this.relevancyScore = relevancyScore;
    }

   public ShopperProduct(){

   }
    public ShopperProduct(String uuid,String shopperId, String productId, Double relevancyScore) {

        this.id=uuid;
        this.shopperId = shopperId;
        this.productId = productId;
        this.relevancyScore = relevancyScore;
    }
}
