package com.example.thuctap.controller;

import com.example.thuctap.Types.DataAddToCart;
import com.example.thuctap.model.Product;
import com.example.thuctap.services.Product.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/ttcm")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/product")
    public Product createProduct(@ModelAttribute Product product) { return productService.createProduct(product); }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/category/products")
    public List<Product> getProductByCategory(@RequestParam Long categoryId) { return productService.getProductByCategory(categoryId); }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/products")
    public List<Product> getAllProducts() { return productService.getAllProducts(); }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/product")
    public Product getProduct(@RequestParam Long id) { return  productService.getProduct(id); }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/search")
    public List<Product> searchProduct(@RequestParam String keyword) { return productService.searchProduct(keyword); }

    //?1 is product_id, ?2 is quantity
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/addToCart")
    public boolean addProductToCart(@RequestBody DataAddToCart dataAddToCart) { return productService.addProductToCart(dataAddToCart); }
}
