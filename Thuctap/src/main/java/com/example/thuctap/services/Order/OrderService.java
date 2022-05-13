package com.example.thuctap.services.Order;

import com.example.thuctap.Types.CartResponse;
import com.example.thuctap.model.Customer;

import java.util.List;

public interface OrderService {
    CartResponse getCart(Long customerId);
}
