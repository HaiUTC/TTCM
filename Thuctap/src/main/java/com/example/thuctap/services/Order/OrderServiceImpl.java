package com.example.thuctap.services.Order;

import com.example.thuctap.Types.CartResponse;
import com.example.thuctap.Types.OrderDetailResponse;
import com.example.thuctap.entity.OrderDetailEntity;
import com.example.thuctap.entity.OrderEntity;
import com.example.thuctap.entity.ProductEntity;
import com.example.thuctap.model.Customer;
import com.example.thuctap.model.Order;
import com.example.thuctap.model.OrderDetail;
import com.example.thuctap.model.Product;
import com.example.thuctap.repository.OrderDetailRepository;
import com.example.thuctap.repository.OrderRepository;
import com.example.thuctap.repository.ProductRepository;
import com.example.thuctap.services.OrderDetail.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService{
    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final ProductRepository productRepository;

    public OrderServiceImpl(OrderRepository orderRepository, OrderDetailRepository orderDetailRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.orderDetailRepository = orderDetailRepository;
        this.productRepository = productRepository;
    }

    @Override
    public CartResponse getCart(Long customerId) {
        CartResponse cartResponse = new CartResponse();
        List<OrderEntity> orderEntityList = orderRepository.findAll();
        List<OrderEntity> orderEntityList1 = new ArrayList<>();
        for(int i=0;i<orderEntityList.size();i++){
            if(orderEntityList.get(i).getStatus().equalsIgnoreCase("pending") && orderEntityList.get(i).getCustomerId() == customerId){
                orderEntityList1.add(orderEntityList.get(i));
            }
        }
        if(orderEntityList1.size() == 0){
            return null;
        }
        OrderEntity orderEntity = orderEntityList1.get(0);

        Order order = new Order(orderEntity.getId(), orderEntity.getCustomerId(), orderEntity.getPrice(), orderEntity.getStatus());
        List<OrderDetailEntity> orderDetailEntityList = orderDetailRepository.findAll();
        List<OrderDetailEntity> orderDetailEntityList1 = new ArrayList<>();
        for(int i=0; i< orderDetailEntityList.size(); i++) {
            if(orderDetailEntityList.get(i).getOrder_id() == order.getId()){
                orderDetailEntityList1.add(orderDetailEntityList.get(i));
            }
        }

        List<OrderDetailResponse> orderDetailResponseList = new ArrayList<OrderDetailResponse>();
        System.out.println(orderDetailEntityList1);
        for(int i=0;i<orderDetailEntityList1.size();i++){
            Long productId = orderDetailEntityList1.get(i).getProduct_id();
            List<ProductEntity> productList = new ArrayList<>();
            List<ProductEntity> productEntityList = productRepository.findAll();
            for(int j=0;j<productEntityList.size();j++){
                if(productEntityList.get(j).getId() == productId) {
                    productList.add(productEntityList.get(j));
                }
            }
            System.out.println(productList);
            for(int k=0;k<productList.size();k++){
                OrderDetailResponse orderDetailResponse = new OrderDetailResponse();
                orderDetailResponse.setOrder_id(orderDetailEntityList1.get(i).getOrder_id());
                orderDetailResponse.setPrice(orderDetailEntityList1.get(i).getPrice());
                orderDetailResponse.setQuantity(orderDetailEntityList1.get(i).getQuantity());
                orderDetailResponse.setProduct(new Product(
                        productList.get(k).getId(),
                        productList.get(k).getName(),
                        productList.get(k).getPrice(),
                        productList.get(k).getBrand(),
                        productList.get(k).getDescription(),
                        productList.get(k).getImage(),
                        productList.get(k).getCategory_id()

                ));
                orderDetailResponseList.add(orderDetailResponse);
            }

        }

        cartResponse.setPrice(order.getPrice());
        cartResponse.setId(order.getId());
        cartResponse.setCustomerId(customerId);
        cartResponse.setStatus(order.getStatus());
        cartResponse.setOrderDetailList(orderDetailResponseList);
        return cartResponse;
    }
}
