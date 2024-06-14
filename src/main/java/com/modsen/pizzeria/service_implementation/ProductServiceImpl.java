package com.modsen.pizzeria.service_implementation;

import com.modsen.pizzeria.dto.ProductDTO;
import com.modsen.pizzeria.service.ProductService;
import org.springframework.stereotype.Service;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private List<ProductDTO> products = new ArrayList<>();

    @Override
    public ProductDTO createProduct(@Valid @NotNull ProductDTO productDTO) {
        return null;
    }

    @Override
    public ProductDTO updateProduct(@NotNull Long id, @Valid @NotNull ProductDTO productDTO) {
        return null;
    }

    @Override
    public void deleteProduct(@NotNull Long id) {}

    @Override
    public ProductDTO getProductById(@NotNull Long id) {
        return null;
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return null;
    }

}
