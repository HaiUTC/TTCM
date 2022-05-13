package com.example.thuctap.Types;

import com.example.thuctap.entity.OrderDetailEntity;
import com.example.thuctap.model.OrderDetail;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class CartResponse {
    private Long id;
    private Double price;
    private Long customerId;
    private String status;
    @JsonProperty("carts")
    private List<OrderDetailResponse> orderDetailList;

    public void setId(Long id) {
        this.id = id;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setOrderDetailList(List<OrderDetailResponse> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }
}
