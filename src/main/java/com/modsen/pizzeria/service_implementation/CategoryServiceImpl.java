package com.modsen.pizzeria.service_implementation;

import com.modsen.pizzeria.dto.CategoryDTO;
import com.modsen.pizzeria.service.CategoryService;
import org.springframework.stereotype.Service;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Override
    public CategoryDTO createCategory(@Valid @NotNull CategoryDTO categoryDTO) {
        return null;
    }

    @Override
    public CategoryDTO updateCategory(@NotNull Long id, @Valid @NotNull CategoryDTO categoryDTO) {
        return null;
    }

    @Override
    public void deleteCategory(@NotNull Long id) {}

    @Override
    public CategoryDTO getCategoryById(@NotNull Long id) {
        return null;
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        return null;
    }

}
