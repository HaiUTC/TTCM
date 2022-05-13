package com.example.thuctap.repository;

import com.example.thuctap.entity.CustomerEntity;
import com.example.thuctap.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
    Customer findByEmail(String email);
    Customer findByEmailAndPassword(String email, String password);
}
