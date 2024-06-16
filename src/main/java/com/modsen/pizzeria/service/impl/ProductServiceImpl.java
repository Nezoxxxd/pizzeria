package com.modsen.pizzeria.service.impl;

import com.modsen.pizzeria.dto.ProductDto;
import com.modsen.pizzeria.service.ProductService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private List<ProductDto> products = new ArrayList<>();

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        return null;
    }

    @Override
    public ProductDto updateProduct(Long id, ProductDto productDto) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {}

    @Override
    public ProductDto getProductById(Long id) {
        return null;
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return null;
    }

}
