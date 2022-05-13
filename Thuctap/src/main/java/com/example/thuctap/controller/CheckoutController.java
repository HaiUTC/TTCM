package com.example.thuctap.controller;

import com.example.thuctap.services.Checkout.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/ttcm")
public class CheckoutController {
    private final CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/checkout")
    public boolean checkout(@RequestParam Long id){ return checkoutService.checkout(id); }
}
