package com.modsen.pizzeria.service.impl;

import com.modsen.pizzeria.dto.CategoryResponse;
import com.modsen.pizzeria.service.CategoryService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Override
    public CategoryResponse createCategory(CategoryResponse categoryResponse) {
        return null;
    }

    @Override
    public CategoryResponse updateCategory(Long id, CategoryResponse categoryResponse) {
        return null;
    }

    @Override
    public void deleteCategory(Long id) {}

    @Override
    public CategoryResponse getCategoryById(Long id) {
        return null;
    }

    @Override
    public List<CategoryResponse> getAllCategories() {
        return null;
    }

}
