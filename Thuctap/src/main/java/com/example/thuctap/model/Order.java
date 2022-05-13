package com.example.thuctap.model;

import lombok.Data;

@Data
public class Order {
    private Long id;
    private Long customer;
    private Double price;
    private String status;

    public Order(Long id, Long customer_id, Double price, String status) {
        this.id = id;
        this.customer = customer_id;
        this.price = price;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomer_id() {
        return customer;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer = customer_id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
