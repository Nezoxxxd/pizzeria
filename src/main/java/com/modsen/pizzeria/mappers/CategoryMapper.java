package com.modsen.pizzeria.mappers;

import com.modsen.pizzeria.domain.Category;
import com.modsen.pizzeria.dto.response.CategoryResponse;
import com.modsen.pizzeria.dto.request.CreateCategoryRequest;
import com.modsen.pizzeria.dto.request.UpdateCategoryRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryResponse toCategoryResponse(Category category);

    Category toCategory(CategoryResponse categoryResponse);
    Category toCategory(CreateCategoryRequest createCategoryRequest);
    Category toCategory(UpdateCategoryRequest updateCategoryRequest);

}
