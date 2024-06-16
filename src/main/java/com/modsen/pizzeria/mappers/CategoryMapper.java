package com.modsen.pizzeria.mappers;

import com.modsen.pizzeria.domain.Category;
import com.modsen.pizzeria.dto.CategoryDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDto toCategoryDto(Category category);

    Category toCategory(CategoryDto categoryDto);

}
