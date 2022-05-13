package com.example.thuctap.Types;

import lombok.Data;

@Data
public class DataAddToCart {
    private Long productId;
    private Long quantity;
    private Long customerId;

    public Long getProductId() {
        return productId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public Long getCustomerId() {
        return customerId;
    }
}
