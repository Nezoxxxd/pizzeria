package com.modsen.pizzeria.service.impl;

import com.modsen.pizzeria.domain.Category;
import com.modsen.pizzeria.dto.response.CategoryResponse;
import com.modsen.pizzeria.dto.request.CreateCategoryRequest;
import com.modsen.pizzeria.dto.request.UpdateCategoryRequest;
import com.modsen.pizzeria.mappers.CategoryMapper;
import com.modsen.pizzeria.repository.CategoryRepository;
import com.modsen.pizzeria.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public CategoryResponse createCategory(CreateCategoryRequest createCategoryRequest) {
        if(categoryRepository.findByName(createCategoryRequest.name()) != null) {
            // todo DuplicateResourceException
        }

        Category category = categoryMapper.toCategory(createCategoryRequest);
        return categoryMapper.toCategoryResponse(categoryRepository.save(category));
    }

    @Override
    public CategoryResponse updateCategory(Long id, UpdateCategoryRequest updateCategoryRequest) {
        Category existingCategory = categoryRepository.findById(id)
                .orElseThrow();

        existingCategory.setName(updateCategoryRequest.name());

        Category updatedCategory = categoryRepository.save(existingCategory);
        return categoryMapper.toCategoryResponse(updatedCategory);
    }

    @Override
    public void deleteCategory(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow();

        categoryRepository.deleteById(id);
    }

    @Override
    public CategoryResponse getCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow();

        return categoryMapper.toCategoryResponse(category);
    }

    @Override
    public List<CategoryResponse> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(categoryMapper::toCategoryResponse).toList();
    }
}
