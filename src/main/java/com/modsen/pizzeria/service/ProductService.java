package com.modsen.pizzeria.service;

import com.modsen.pizzeria.dto.response.ProductResponse;
import com.modsen.pizzeria.dto.request.CreateProductRequest;
import com.modsen.pizzeria.dto.request.UpdateProductRequest;

import java.util.List;

public interface ProductService {

    ProductResponse createProduct(CreateProductRequest createProductRequest);

    ProductResponse updateProduct(Long id, UpdateProductRequest updateProductRequest);

    void deleteProduct(Long id);

    ProductResponse getProductById(Long id);

    List<ProductResponse> getAllProducts();

}
