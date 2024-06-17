package com.modsen.pizzeria.service.impl;

import com.modsen.pizzeria.dto.ProductResponse;
import com.modsen.pizzeria.service.ProductService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private List<ProductResponse> products = new ArrayList<>();

    @Override
    public ProductResponse createProduct(ProductResponse productResponse) {
        return null;
    }

    @Override
    public ProductResponse updateProduct(Long id, ProductResponse productResponse) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {}

    @Override
    public ProductResponse getProductById(Long id) {
        return null;
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        return null;
    }

}
