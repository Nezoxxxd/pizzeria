package com.modsen.pizzeria.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class ProductDTO {

    private Long id;

    @NotBlank(message = "Product name is required")
    private String name;

    @NotNull(message = "Product price is required")
    @Positive(message = "Product price must be positive")
    private Double price;

    @NotBlank(message = "Product description is required")
    private String description;

    @NotNull(message = "Category ID is required")
    private Long categoryId;

}

