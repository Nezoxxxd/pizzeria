package com.modsen.pizzeria.service;

import com.modsen.pizzeria.dto.ProductDTO;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface ProductService {

    ProductDTO createProduct(@Valid @NotNull ProductDTO productDTO);

    ProductDTO updateProduct(@NotNull Long id, @Valid @NotNull ProductDTO productDTO);

    void deleteProduct(@NotNull Long id);

    ProductDTO getProductById(@NotNull Long id);

    List<ProductDTO> getAllProducts();

}
