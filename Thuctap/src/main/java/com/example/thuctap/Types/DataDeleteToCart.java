package com.example.thuctap.Types;

import lombok.Data;

@Data
public class DataDeleteToCart {
    private Long productId;
    private Long orderId;

    public DataDeleteToCart() {}

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
