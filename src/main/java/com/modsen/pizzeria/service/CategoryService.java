package com.modsen.pizzeria.service;

import com.modsen.pizzeria.dto.CategoryResponse;
import java.util.List;

public interface CategoryService {

    CategoryResponse createCategory(CategoryResponse categoryResponse);

    CategoryResponse updateCategory(Long id, CategoryResponse categoryResponse);

    void deleteCategory(Long id);

    CategoryResponse getCategoryById(Long id);

    List<CategoryResponse> getAllCategories();

}
