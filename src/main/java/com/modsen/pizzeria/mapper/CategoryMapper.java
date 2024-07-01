package com.modsen.pizzeria.mapper;

import com.modsen.pizzeria.domain.Category;
import com.modsen.pizzeria.dto.response.CategoryResponse;
import com.modsen.pizzeria.dto.request.CreateCategoryRequest;
import com.modsen.pizzeria.dto.request.UpdateCategoryRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CategoryMapper {

    CategoryResponse toCategoryResponse(Category category);

    Category toCategory(CategoryResponse categoryResponse);
    Category toCategory(CreateCategoryRequest createCategoryRequest);
    Category toCategory(UpdateCategoryRequest updateCategoryRequest);

    @Mapping(target = "id", ignore = true)
    void updateCategoryFromRequest(UpdateCategoryRequest updateCategoryRequest, @MappingTarget Category category);
}
