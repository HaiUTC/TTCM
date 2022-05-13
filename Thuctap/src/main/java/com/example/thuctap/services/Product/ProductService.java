package com.example.thuctap.services.Product;

import com.example.thuctap.Types.DataAddToCart;
import com.example.thuctap.model.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {
    Product createProduct(Product product);

    List<Product> getAllProducts();

    Product getProduct(Long id);

    List<Product> searchProduct(String keyword);

    List<Product> getProductByCategory(Long categoryId);

    boolean addProductToCart(DataAddToCart dataAddToCart);
}
