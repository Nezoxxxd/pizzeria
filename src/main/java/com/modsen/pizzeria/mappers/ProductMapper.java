package com.modsen.pizzeria.mappers;

import com.modsen.pizzeria.domain.Product;
import com.modsen.pizzeria.dto.ProductDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDto toProductDto(Product product);

    Product toProduct(ProductDto productDto);

}

