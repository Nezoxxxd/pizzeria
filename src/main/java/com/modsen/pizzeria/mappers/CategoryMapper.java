package com.modsen.pizzeria.mappers;

import com.modsen.pizzeria.domain.Category;
import com.modsen.pizzeria.dto.CategoryResponse;
import com.modsen.pizzeria.dto.create.CreateCategoryRequest;
import com.modsen.pizzeria.dto.update.UpdateCategoryRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryResponse toCategoryResponse(Category category);

    Category toCategory(CategoryResponse categoryResponse);
    Category toCategory(CreateCategoryRequest createCategoryRequest);
    Category toCategory(UpdateCategoryRequest updateCategoryRequest);

}
