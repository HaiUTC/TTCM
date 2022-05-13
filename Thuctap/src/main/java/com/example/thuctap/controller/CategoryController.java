package com.example.thuctap.controller;

import com.example.thuctap.model.Category;
import com.example.thuctap.services.Category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ttcm")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/categorys")
    public List<Category> getAllCategory(){ return  categoryService.getAllCategory(); }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/category")
    public boolean createCategory(@RequestBody Category category) { return categoryService.createCategory(category); }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/category")
    public boolean deleteCategory(@RequestBody Long id) { return  categoryService.deleteCategory(id); }
}
