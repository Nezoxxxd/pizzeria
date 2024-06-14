package com.modsen.pizzeria.mappers;

import com.modsen.pizzeria.domain.Product;
import com.modsen.pizzeria.dto.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Product toModel(ProductDTO productDTO);

    ProductDTO toDTO(Product productModel);
}
