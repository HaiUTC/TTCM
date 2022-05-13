package com.example.thuctap.Types;

import lombok.Data;

@Data
public class DataChangeQuantity {
    public Long productId;
    public Long orderId;
    public Long quantity;

    public DataChangeQuantity(Long productId, Long orderId, Long quantity) {
        this.productId = productId;
        this.orderId = orderId;
        this.quantity = quantity;
    }

    public DataChangeQuantity() {}

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

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
