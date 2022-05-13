package com.example.thuctap.services.Category;

import com.example.thuctap.model.Category;

import java.util.List;

public interface CategoryService {
    boolean createCategory(Category category);

    boolean deleteCategory(Long id);

    List<Category> getAllCategory();
}
