package com.modsen.pizzeria.service.impl;

import com.modsen.pizzeria.domain.Product;
import com.modsen.pizzeria.dto.response.ProductResponse;
import com.modsen.pizzeria.dto.request.CreateProductRequest;
import com.modsen.pizzeria.dto.request.UpdateProductRequest;
import com.modsen.pizzeria.error.ErrorMessage;
import com.modsen.pizzeria.exception.ResourceNotFoundException;
import com.modsen.pizzeria.mappers.ProductMapper;
import com.modsen.pizzeria.repository.ProductRepository;
import com.modsen.pizzeria.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
        Product existingProduct = findProductByIdOrThrow(id);
        productMapper.updateProductFromRequest(updateProductRequest, existingProduct);

        Product updatedProduct = productRepository.save(existingProduct);
        return productMapper.toProductResponse(updatedProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = findProductByIdOrThrow(id);
        productRepository.deleteById(id);
    }

    @Override
    public ProductResponse getProductById(Long id) {
        Product product = findProductByIdOrThrow(id);
        return productMapper.toProductResponse(product);
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll().stream().map(productMapper::toProductResponse).toList();
    }

    private Product findProductByIdOrThrow(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format(ErrorMessage.RESOURCE_NOT_FOUND, "Product", id)));
    }
}
