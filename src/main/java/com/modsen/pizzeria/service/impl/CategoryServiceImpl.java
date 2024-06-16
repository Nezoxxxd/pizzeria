package com.modsen.pizzeria.service.impl;

import com.modsen.pizzeria.dto.CategoryDto;
import com.modsen.pizzeria.service.CategoryService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        return null;
    }

    @Override
    public CategoryDto updateCategory(Long id, CategoryDto categoryDto) {
        return null;
    }

    @Override
    public void deleteCategory(Long id) {}

    @Override
    public CategoryDto getCategoryById(Long id) {
        return null;
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        return null;
    }

}
