package com.example.thuctap.controller;

import com.example.thuctap.Types.LoginDataInput;
import com.example.thuctap.model.Customer;
import com.example.thuctap.services.Customer.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/ttcm")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/customers")
    public List<Customer> getAllCustomer(){ return  customerService.getAllCustomer(); }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/customer")
    public Customer getCustomer(@RequestBody Long id) { return customerService.getCustomer(id); }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/register")
    public boolean createCustomer(@RequestBody Customer customer){
        return customerService.createCustomer(customer);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/login")
    public Customer loginCustomer(@RequestBody LoginDataInput loginDataInput) { return customerService.loginCustomer(loginDataInput); }
}
