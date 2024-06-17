package com.modsen.pizzeria.service;

import com.modsen.pizzeria.dto.ProductResponse;
import com.modsen.pizzeria.dto.create.CreateProductRequest;
import com.modsen.pizzeria.dto.update.UpdateProductRequest;

import java.util.List;

public interface ProductService {

    ProductResponse createProduct(CreateProductRequest createProductRequest);

    ProductResponse updateProduct(Long id, UpdateProductRequest updateProductRequest);

    void deleteProduct(Long id);

    ProductResponse getProductById(Long id);

    List<ProductResponse> getAllProducts();

}
