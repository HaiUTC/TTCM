package com.example.thuctap.services.Checkout;

import com.example.thuctap.entity.CheckoutEntity;
import com.example.thuctap.entity.CustomerEntity;
import com.example.thuctap.entity.OrderEntity;
import com.example.thuctap.repository.CheckoutRepository;
import com.example.thuctap.repository.CustomerRepository;
import com.example.thuctap.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CheckoutServiceImpl implements  CheckoutService{
    private final CheckoutRepository checkoutRepository;
    private final OrderRepository orderRepository;

    public CheckoutServiceImpl(CheckoutRepository checkoutRepository, OrderRepository orderRepository ) {
        this.checkoutRepository = checkoutRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public boolean checkout(Long id) {
        try{
            OrderEntity orderEntity = orderRepository.getById(id);
            CheckoutEntity checkoutEntity = new CheckoutEntity();
            if(orderEntity.getStatus().equalsIgnoreCase("pending")){
                orderEntity.setStatus("paid");
                orderRepository.save(orderEntity);
                checkoutEntity.setOrder(id);
                checkoutRepository.save(checkoutEntity);
                return true;
            }
            return false;

        } catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
