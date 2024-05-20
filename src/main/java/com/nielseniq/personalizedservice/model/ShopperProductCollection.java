package com.nielseniq.personalizedservice.model;



import java.util.List;


public class ShopperProductCollection {


    private String shopperId;


     private List<Product> shelf;


    public List<Product> getShelf() {
        return shelf;
    }

    public void setShelf(List<Product> shelf) {
        this.shelf = shelf;
    }


    public String getShopperId() {
        return shopperId;
    }

    public void setShopperId(String shopperId) {
        this.shopperId = shopperId;
    }

}
