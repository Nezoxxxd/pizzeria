package com.modsen.pizzeria.service.impl;

import com.modsen.pizzeria.dto.response.ProductResponse;
import com.modsen.pizzeria.dto.request.CreateProductRequest;
import com.modsen.pizzeria.dto.request.UpdateProductRequest;
import com.modsen.pizzeria.service.ProductService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private List<ProductResponse> products = new ArrayList<>();
    
    @Override
    public ProductResponse createProduct(CreateProductRequest createProductRequest) {return null;}

    @Override
    public ProductResponse updateProduct(Long id, UpdateProductRequest updateProductRequest) {return null;}

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
