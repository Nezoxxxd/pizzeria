package com.modsen.pizzeria.service;

import com.modsen.pizzeria.dto.CategoryDTO;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface CategoryService {

    CategoryDTO createCategory(@Valid @NotNull CategoryDTO categoryDTO);

    CategoryDTO updateCategory(@NotNull Long id, @Valid @NotNull CategoryDTO categoryDTO);

    void deleteCategory(@NotNull Long id);

    CategoryDTO getCategoryById(@NotNull Long id);

    List<CategoryDTO> getAllCategories();

}
