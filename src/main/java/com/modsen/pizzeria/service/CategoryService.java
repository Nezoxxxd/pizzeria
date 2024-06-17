package com.modsen.pizzeria.service;

import com.modsen.pizzeria.dto.CategoryResponse;
import com.modsen.pizzeria.dto.create.CreateCategoryRequest;
import com.modsen.pizzeria.dto.update.UpdateCategoryRequest;

import java.util.List;

public interface CategoryService {

    CategoryResponse createCategory(CreateCategoryRequest createCategoryRequest);

    CategoryResponse updateCategory(Long id, UpdateCategoryRequest updateCategoryRequest);

    void deleteCategory(Long id);

    CategoryResponse getCategoryById(Long id);

    List<CategoryResponse> getAllCategories();

}
