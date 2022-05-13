package com.example.thuctap.Types;

import com.example.thuctap.model.Order;

import javax.persistence.Id;
import java.io.Serializable;

public class OrderDetailId implements Serializable {
    private Long order_id;
    private Long product_id;

    public OrderDetailId(Long order_id, Long product_id) {
        this.order_id = order_id;
        this.product_id = product_id;
    }
    public OrderDetailId(){}

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
}
