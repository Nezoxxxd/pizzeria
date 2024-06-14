package com.modsen.pizzeria.dto;

import com.modsen.pizzeria.domain.Category;
import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class ProductDTO {

    @NotNull(message = "ID is required")
    private Long id;

    @NotNull(message = "Product name is required")
    private String name;

    @NotNull(message = "Product price is required")
    @Positive(message = "Product price must be positive")
    private Double price;

    @NotNull(message = "Product description is required")
    private String description;

    @NotNull(message = "Category is required")
    private Category category;

}

