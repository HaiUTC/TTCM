package com.example.thuctap.services.Customer;

import com.example.thuctap.Types.LoginDataInput;
import com.example.thuctap.entity.CustomerEntity;
import com.example.thuctap.helpers.MD5;
import com.example.thuctap.model.Customer;
import com.example.thuctap.repository.CustomerRepository;
import com.example.thuctap.services.Customer.CustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public boolean createCustomer(Customer customer) {
        CustomerEntity customerEntity = new CustomerEntity();
        MD5 md5 = new MD5();
        Customer checkCustomer = customerRepository.findByEmail(customer.getEmail());
        if(checkCustomer != null){
            return false;
        }
        customer.setRole("user");
        customer.setPassword(md5.MD5(customer.getPassword()));
        BeanUtils.copyProperties(customer, customerEntity);
        CustomerEntity newCustomer = customerRepository.save(customerEntity);
        if(newCustomer != null){
            return true;
        }
        return false;
    }

    @Override
    public List<Customer> getAllCustomer() {
        List<CustomerEntity> customerEntities = customerRepository.findAll();
        List<Customer> customers = customerEntities.stream().map(customer -> new Customer(
                customer.getId(),
                customer.getName(),
                customer.getEmail(),
                customer.getPassword(),
                customer.getAddress(),
                customer.getRole()
        )).collect(Collectors.toList());
        return customers;
    }

    @Override
    public Customer getCustomer(Long id) {
        CustomerEntity customer = customerRepository.getById(id);
        Customer response = new Customer(
                customer.getId(),
                customer.getName(),
                customer.getEmail(),
                customer.getPassword(),
                customer.getAddress(),
                customer.getRole());
        return response;
    }

    @Override
    public Customer loginCustomer(LoginDataInput loginDataInput) {
        MD5 md5 = new MD5();
        Customer customer = customerRepository.findByEmailAndPassword(loginDataInput.getEmail(), md5.MD5(loginDataInput.getPassword()));
        if(customer == null){
            return null;
        }
        return customer;
    }
}
