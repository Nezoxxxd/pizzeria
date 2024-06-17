package com.modsen.pizzeria.service;

import com.modsen.pizzeria.dto.ProductResponse;
import java.util.List;

public interface ProductService {

    ProductResponse createProduct(ProductResponse productResponse);

    ProductResponse updateProduct(Long id, ProductResponse productResponse);

    void deleteProduct(Long id);

    ProductResponse getProductById(Long id);

    List<ProductResponse> getAllProducts();

}
