package com.modsen.pizzeria.service.impl;

import com.modsen.pizzeria.domain.Product;
import com.modsen.pizzeria.dto.response.ProductResponse;
import com.modsen.pizzeria.dto.request.CreateProductRequest;
import com.modsen.pizzeria.dto.request.UpdateProductRequest;
import com.modsen.pizzeria.exception.ResourceNotFoundException;
import com.modsen.pizzeria.mappers.ProductMapper;
import com.modsen.pizzeria.repository.ProductRepository;
import com.modsen.pizzeria.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    
    @Override
    public ProductResponse createProduct(CreateProductRequest createProductRequest) {
        Product product = productMapper.toProduct(createProductRequest);
        return productMapper.toProductResponse(productRepository.save(product));
    }

    @Override
    public ProductResponse updateProduct(Long id, UpdateProductRequest updateProductRequest) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException("Product with id " + id + " does not exist") );

        existingProduct.setName(updateProductRequest.name());
        existingProduct.setDescription(updateProductRequest.description());
        existingProduct.setPrice( BigDecimal.valueOf(updateProductRequest.price()) );
        existingProduct.setCategory(updateProductRequest.category());

        Product updatedProduct = productRepository.save(existingProduct);
        return productMapper.toProductResponse(updatedProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException("Product with id " + id + " does not exist") );

        productRepository.deleteById(id);
    }

    @Override
    public ProductResponse getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException("Product with id " + id + " does not exist") );

        return productMapper.toProductResponse(product);
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(productMapper::toProductResponse).toList();
    }

}
