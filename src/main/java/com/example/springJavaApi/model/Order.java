package com.example.springJavaApi.model;

import java.util.Collections;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

public class Order {

    @Transient
    public static final String SEQUENCE_NAME = "orders_sequence";
    
    @Id
    private String id;
    
    private long orderNum;
    private String date;
    private int numProducts;
    private int finalPrice;
    private List<Object> productList;

    public List<Object> getProductList() {
        return productList;
    }

    public void setProductList(List<Object> productList) {
        this.productList = productList;
    }

    public Order(String id, long orderNum, String date, int numProducts, int finalPrice, List<Object> productList) {
        super();
        this.id = id;
        this.orderNum = orderNum;
        this.date = date;
        this.numProducts = numProducts;
        this.finalPrice = finalPrice;
        this.productList = productList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(long l) {
        this.orderNum = l;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNumProducts() {
        return numProducts;
    }

    public void setNumProducts(int numProducts) {
        this.numProducts = numProducts;
    }

    public int getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(int finalPrice) {
        this.finalPrice = finalPrice;
    }

}