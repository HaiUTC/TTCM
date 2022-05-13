package com.example.thuctap.services.Product;

import com.example.thuctap.Types.DataAddToCart;
import com.example.thuctap.entity.OrderDetailEntity;
import com.example.thuctap.entity.OrderEntity;
import com.example.thuctap.entity.ProductEntity;
import com.example.thuctap.model.Order;
import com.example.thuctap.model.Product;
import com.example.thuctap.repository.OrderDetailRepository;
import com.example.thuctap.repository.OrderRepository;
import com.example.thuctap.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;

    public ProductServiceImpl(ProductRepository productRepository, OrderRepository orderRepository, OrderDetailRepository orderDetailRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        this.orderDetailRepository = orderDetailRepository;
    }

    @Override
    public Product createProduct(Product product) {
        ProductEntity productEntity = new ProductEntity();
       try {
           product.setImage(product.getImageFile().getOriginalFilename());
           String pathFile = "C:\\Users\\Admin\\TTCM\\Thuctap\\src\\main\\resources\\static\\images\\" + product.getImage();
           product.getImageFile().transferTo(Path.of(pathFile));
           product.setImageFile(null);
           BeanUtils.copyProperties(product, productEntity);
           ProductEntity newProduct = productRepository.save(productEntity);
           System.out.println(newProduct);
           return new Product(
                   newProduct.getId(),
                   newProduct.getName(),
                   newProduct.getPrice(),
                   newProduct.getBrand(),
                   newProduct.getDescription(),
                   newProduct.getImage(),
                   newProduct.getCategory_id()
           );
       } catch (Exception c){
           c.printStackTrace();
       }
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        List<ProductEntity> productEntityList = productRepository.findAll();
        List<Product> products = productEntityList.stream().map(product -> new Product(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getBrand(),
                product.getDescription(),
                product.getImage(),
                product.getCategory_id()
        )).collect(Collectors.toList());
        return products;
    }

    @Override
    public Product getProduct(Long id) {
        try {
            ProductEntity productEntity = productRepository.getById(id);

            Product product = new Product(
                    productEntity.getId(),
                    productEntity.getName(),
                    productEntity.getPrice(),
                    productEntity.getBrand(),
                    productEntity.getDescription(),
                    productEntity.getImage(),
                    productEntity.getCategory_id()
            );
            return product;
        } catch (Exception e){
            System.out.println("Have error in GetProduct : " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<Product> searchProduct(String keyword) {
        List<ProductEntity> productEntityList = productRepository.findAll();
        List<Product> productList = (List<Product>) productEntityList.stream().map(product ->
                product.getName().contains(keyword) ? new Product(
                        product.getId(),
                        product.getName(),
                        product.getPrice(),
                        product.getBrand(),
                        product.getDescription(),
                        product.getImage(),
                        product.getCategory_id()
                ): null).collect(Collectors.toList());
        return productList;
    }

    @Override
    public List<Product> getProductByCategory(Long categoryId) {
        List<ProductEntity> productEntityList = productRepository.findAll();
        List<Product> productList = (List<Product>) productEntityList.stream().map(product ->
                product.getCategory_id() == categoryId ? new Product(
                        product.getId(),
                        product.getName(),
                        product.getPrice(),
                        product.getBrand(),
                        product.getDescription(),
                        product.getImage(),
                        product.getCategory_id()
                ) : null
        ).collect(Collectors.toList());
        return productList;
    }

    @Override
    public boolean addProductToCart(DataAddToCart dataAddToCart) {
        try{
            ProductEntity productEntity = productRepository.getById(dataAddToCart.getProductId());
            if (productEntity.getId() == null){
                return false;
            }
            List<Order> order = new ArrayList<>();
            List<OrderEntity> orderEntityList = orderRepository.findAll();
            for(int i=0;i<orderEntityList.size(); i++){
                if(orderEntityList.get(i).getCustomerId() == dataAddToCart.getCustomerId() && orderEntityList.get(i).getStatus().equalsIgnoreCase("pending")){
                    order.add(new Order(
                            orderEntityList.get(i).getId(),
                            orderEntityList.get(i).getCustomerId(),
                            orderEntityList.get(i).getPrice(),
                            orderEntityList.get(i).getStatus()
                    ));
                }
            }
            if (order.size() == 0){
                OrderEntity orderEntity = new OrderEntity();
                orderEntity.setCustomer(dataAddToCart.getCustomerId());
                orderEntity.setPrice(0.0);
                orderEntity.setStatus("pending");
                OrderEntity orderEntity1 = orderRepository.save(orderEntity);
                OrderDetailEntity orderDetailEntity = new OrderDetailEntity();
                orderDetailEntity.setOrder_id(orderEntity1.getId());
                orderDetailEntity.setProduct_id(dataAddToCart.getProductId());
                orderDetailEntity.setQuantity(dataAddToCart.getQuantity());
                orderDetailEntity.setPrice(dataAddToCart.getQuantity() * productEntity.getPrice());
                orderDetailRepository.save(orderDetailEntity);
                return true;
            } else {
                OrderDetailEntity orderDetailEntity = new OrderDetailEntity(
                        order.get(0).getId(),
                        dataAddToCart.getProductId(),
                        dataAddToCart.getQuantity(),
                        dataAddToCart.getQuantity() * productEntity.getPrice()
                );
                orderDetailRepository.save(orderDetailEntity);
                return true;
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
