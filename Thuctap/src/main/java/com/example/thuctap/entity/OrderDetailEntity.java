package com.example.thuctap.entity;

import com.example.thuctap.Types.OrderDetailId;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "order_detail")
@IdClass(OrderDetailId.class)
public class OrderDetailEntity {
    @Id
    private Long order_id;
    @Id
    private Long product_id;
    private Long quantity;
    private double price;

    public OrderDetailEntity(Long order_id, Long product_id, Long quantity, double price) {
        this.order_id = order_id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.price = price;
    }

    public OrderDetailEntity() {}

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
