package com.example.thuctap.services.OrderDetail;

import com.example.thuctap.Types.DataChangeQuantity;
import com.example.thuctap.Types.DataDeleteToCart;
import com.example.thuctap.entity.OrderDetailEntity;
import com.example.thuctap.entity.ProductEntity;
import com.example.thuctap.model.Order;
import com.example.thuctap.model.OrderDetail;
import com.example.thuctap.model.Product;
import com.example.thuctap.repository.OrderDetailRepository;
import com.example.thuctap.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OrderDetailServiceImpl implements OrderDetailService{
    private final OrderDetailRepository orderDetailRepository;
    private final ProductRepository productRepository;

    public OrderDetailServiceImpl(OrderDetailRepository orderDetailRepository, ProductRepository productRepository) {
        this.orderDetailRepository = orderDetailRepository;
        this.productRepository = productRepository;
    }

    @Override
    public OrderDetail changeQuantity(DataChangeQuantity dataChangeQuantity) {
        try{
            OrderDetailEntity orderDetailEntity = new OrderDetailEntity();
            List<OrderDetailEntity> orderDetailEntity1 = orderDetailRepository.findAll();
            List<OrderDetailEntity> orderDetailEntityList = new ArrayList<>();
            for(int i=0; i<orderDetailEntity1.size();i++){
                if(orderDetailEntity1.get(i).getOrder_id() == dataChangeQuantity.getOrderId() && orderDetailEntity1.get(i).getProduct_id() == dataChangeQuantity.getProductId()){
                    orderDetailEntityList.add(orderDetailEntity1.get(i));
                }
            }
            orderDetailEntityList.get(0).setQuantity(dataChangeQuantity.quantity);
            ProductEntity productEntity = productRepository.getById(dataChangeQuantity.getProductId());
            orderDetailEntityList.get(0).setPrice(productEntity.getPrice() * dataChangeQuantity.quantity);

            orderDetailRepository.save(orderDetailEntityList.get(0));
            return new OrderDetail(
                    orderDetailEntityList.get(0).getOrder_id(),
                    orderDetailEntityList.get(0).getProduct_id(),
                    orderDetailEntityList.get(0).getQuantity(),
                    orderDetailEntityList.get(0).getPrice()
            );
        } catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean deleteOrderDetail(DataDeleteToCart dataDeleteToCart) {
        try{
            List<OrderDetailEntity> orderDetailEntity1 = orderDetailRepository.findAll();
            List<OrderDetailEntity> orderDetailEntityList = new ArrayList<>();
            for(int i=0; i<orderDetailEntity1.size();i++){
                if(orderDetailEntity1.get(i).getOrder_id() == dataDeleteToCart.getOrderId() && orderDetailEntity1.get(i).getProduct_id() == dataDeleteToCart.getProductId()){
                    orderDetailEntityList.add(orderDetailEntity1.get(i));
                }
            }
            orderDetailRepository.delete(orderDetailEntityList.get(0));
            return true;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

}
