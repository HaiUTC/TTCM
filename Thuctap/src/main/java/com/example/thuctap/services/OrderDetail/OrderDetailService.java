package com.example.thuctap.services.OrderDetail;

import com.example.thuctap.Types.DataChangeQuantity;
import com.example.thuctap.Types.DataDeleteToCart;
import com.example.thuctap.model.OrderDetail;
import org.springframework.stereotype.Service;

import java.util.Map;


public interface OrderDetailService {
    OrderDetail changeQuantity(DataChangeQuantity dataChangeQuantity);

    boolean deleteOrderDetail(DataDeleteToCart dataDeleteToCart);
}
