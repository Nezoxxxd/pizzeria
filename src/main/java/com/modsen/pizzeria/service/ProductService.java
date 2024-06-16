package com.modsen.pizzeria.service;

import com.modsen.pizzeria.dto.ProductDto;
import java.util.List;

public interface ProductService {

    ProductDto createProduct(ProductDto productDto);

    ProductDto updateProduct(Long id, ProductDto productDto);

    void deleteProduct(Long id);

    ProductDto getProductById(Long id);

    List<ProductDto> getAllProducts();

}
