package com.example.thuctap.repository;

import com.example.thuctap.entity.OrderEntity;
import com.example.thuctap.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

}
