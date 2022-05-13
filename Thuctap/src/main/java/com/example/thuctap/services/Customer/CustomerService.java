package com.example.thuctap.services.Customer;

import com.example.thuctap.Types.LoginDataInput;
import com.example.thuctap.model.Customer;

import java.util.List;
import java.util.Map;

public interface CustomerService {

    List<Customer> getAllCustomer();

    Customer getCustomer(Long id);

    Customer loginCustomer(LoginDataInput loginDataInput);

    boolean createCustomer(Customer customer);
}
