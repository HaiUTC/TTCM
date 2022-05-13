package com.example.thuctap.controller;

import com.example.thuctap.Types.DataChangeQuantity;
import com.example.thuctap.Types.DataDeleteToCart;
import com.example.thuctap.model.OrderDetail;
import com.example.thuctap.services.OrderDetail.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/ttcm")
public class OrderDetailController {
    private final OrderDetailService orderDetailService;

    public OrderDetailController(OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/order-detail/update")
    public OrderDetail changeQuantity(@RequestBody DataChangeQuantity dataChangeQuantity) { return orderDetailService.changeQuantity(dataChangeQuantity); }
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/order-detail/delete")
    public boolean deleteOrderDetail(@RequestBody DataDeleteToCart dataDeleteToCart) { return orderDetailService.deleteOrderDetail(dataDeleteToCart); }
}
