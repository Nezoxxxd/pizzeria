package com.modsen.pizzeria.service.impl;

import com.modsen.pizzeria.dto.CategoryResponse;
import com.modsen.pizzeria.dto.create.CreateCategoryRequest;
import com.modsen.pizzeria.dto.update.UpdateCategoryRequest;
import com.modsen.pizzeria.service.CategoryService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {


    @Override
    public CategoryResponse createCategory(CreateCategoryRequest createCategoryRequest) {return null;}

    @Override
    public CategoryResponse updateCategory(Long id, UpdateCategoryRequest updateCategoryRequest) {return null;}

    @Override
    public void deleteCategory(Long id) {}

    @Override
    public CategoryResponse getCategoryById(Long id) {return null;}

    @Override
    public List<CategoryResponse> getAllCategories() {return null;}
}
