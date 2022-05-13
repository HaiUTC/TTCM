package com.example.thuctap.Types;

import com.example.thuctap.model.Product;
import lombok.Data;

@Data
public class OrderDetailResponse {
    private Long order_id;
    private Long quantity;
    private double price;
    private Product product;

    public Long getOrder_id() {
        return order_id;
    }

    public Long getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public Product getProduct() {
        return product;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
