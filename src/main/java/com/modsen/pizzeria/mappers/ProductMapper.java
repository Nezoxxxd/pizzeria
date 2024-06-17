package com.modsen.pizzeria.mappers;

import com.modsen.pizzeria.domain.Product;
import com.modsen.pizzeria.dto.ProductResponse;
import com.modsen.pizzeria.dto.create.CreateProductRequest;
import com.modsen.pizzeria.dto.update.UpdateProductRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductResponse toProductResponse(Product product);

    Product toProduct(ProductResponse productResponse);
    Product toProduct(CreateProductRequest createProductRequest);
    Product toProduct(UpdateProductRequest updateProductRequest);

}

