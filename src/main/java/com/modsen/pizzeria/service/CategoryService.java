package com.modsen.pizzeria.service;

import com.modsen.pizzeria.dto.response.CategoryResponse;
import com.modsen.pizzeria.dto.request.CreateCategoryRequest;
import com.modsen.pizzeria.dto.request.UpdateCategoryRequest;

import java.util.List;

public interface CategoryService {

    CategoryResponse createCategory(CreateCategoryRequest createCategoryRequest);

    CategoryResponse updateCategory(Long id, UpdateCategoryRequest updateCategoryRequest);

    void deleteCategory(Long id);

    CategoryResponse getCategoryById(Long id);

    List<CategoryResponse> getAllCategories();

}
