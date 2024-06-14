package com.modsen.pizzeria.mappers;

import com.modsen.pizzeria.domain.Category;
import com.modsen.pizzeria.dto.CategoryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Category toModel(CategoryDTO orderDTO);

    CategoryDTO toDTO(Category order);
}
