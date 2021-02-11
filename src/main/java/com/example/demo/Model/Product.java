package com.example.demo.Model;

public class Product {
    private long idproduct;
    private String productName;
    private double productPrice;

    public Product() {
    }


    public Product(long idproduct, String name, double price) {
        this.idproduct = idproduct;
        this.productName = name;
        this.productPrice = price;
    }

    public long getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(long idproduct) {
        this.idproduct = idproduct;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
}
