package com.example.thuctap.controller;

import com.example.thuctap.Types.CartResponse;
import com.example.thuctap.model.Customer;
import com.example.thuctap.services.Order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ttcm")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/cart")
    public CartResponse getCart(@RequestParam Long customerId){ return  orderService.getCart(customerId); }
}
