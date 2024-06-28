package com.modsen.pizzeria.controllers;

import com.modsen.pizzeria.swagger.ProductApi;
import com.modsen.pizzeria.dto.request.CreateProductRequest;
import com.modsen.pizzeria.dto.request.UpdateProductRequest;
import com.modsen.pizzeria.dto.response.ProductResponse;
import com.modsen.pizzeria.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/product")
public class ProductController implements ProductApi {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public ProductResponse createProduct(@RequestBody @Valid CreateProductRequest createProductRequest){
        return productService.createProduct(createProductRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public ProductResponse updateProduct(
            @PathVariable Long id,
            @RequestBody @Valid UpdateProductRequest updateProductRequest
    ){
        return productService.updateProduct(id,updateProductRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public ProductResponse getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Override
    public List<ProductResponse> getAllProducts(){
        return productService.getAllProducts();
    }

}
