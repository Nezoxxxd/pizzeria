package com.modsen.pizzeria.service.impl;

import com.modsen.pizzeria.domain.Category;
import com.modsen.pizzeria.dto.response.CategoryResponse;
import com.modsen.pizzeria.dto.request.CreateCategoryRequest;
import com.modsen.pizzeria.dto.request.UpdateCategoryRequest;
import com.modsen.pizzeria.error.ErrorMessages;
import com.modsen.pizzeria.exception.DuplicateResourceException;
import com.modsen.pizzeria.exception.ResourceNotFoundException;
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
        checkCategoryExistence(createCategoryRequest.name());

        Category category = categoryMapper.toCategory(createCategoryRequest);
        return categoryMapper.toCategoryResponse(categoryRepository.save(category));
    }

    @Override
    public CategoryResponse updateCategory(Long id, UpdateCategoryRequest updateCategoryRequest) {
        Category existingCategory = findCategoryByIdOrThrow(id);
        categoryMapper.updateCategoryFromRequest(updateCategoryRequest, existingCategory);

        Category updatedCategory = categoryRepository.save(existingCategory);
        return categoryMapper.toCategoryResponse(updatedCategory);
    }

    @Override
    public void deleteCategory(Long id) {
        Category category = findCategoryByIdOrThrow(id);
        categoryRepository.deleteById(id);
    }

    @Override
    public CategoryResponse getCategoryById(Long id) {
        Category category = findCategoryByIdOrThrow(id);
        return categoryMapper.toCategoryResponse(category);
    }

    @Override
    public List<CategoryResponse> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(categoryMapper::toCategoryResponse)
                .toList();
    }

    private Category findCategoryByIdOrThrow(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format(ErrorMessages.RESOURCE_NOT_FOUND_MESSAGE, "Category", id)));
    }

    private void checkCategoryExistence(String categoryName) {
        if(categoryRepository.existsByName(categoryName)) {
            throw new DuplicateResourceException(String.format(ErrorMessages.DUPLICATE_RESOURCE_MESSAGE, "Category", "name"));
        }
    }
}
