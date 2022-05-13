package com.example.thuctap.services.Category;

import com.example.thuctap.entity.CategoryEntity;
import com.example.thuctap.model.Category;
import com.example.thuctap.repository.CategoryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public boolean createCategory(Category category) {
        CategoryEntity categoryEntity = new CategoryEntity();
        BeanUtils.copyProperties(category, categoryEntity);
        CategoryEntity newCategory = categoryRepository.save(categoryEntity);
        if(newCategory != null){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteCategory(Long id) {
        return false;
    }

    @Override
    public List<Category> getAllCategory() {
        return null;
    }
}
