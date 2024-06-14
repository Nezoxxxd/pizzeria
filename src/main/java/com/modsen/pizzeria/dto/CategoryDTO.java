package com.modsen.pizzeria.dto;

import lombok.Data;
import javax.validation.constraints.NotNull;

@Data
public class CategoryDTO {

    @NotNull(message = "ID cannot be null")
    private Long id;

    @NotNull(message = "Category name is required")
    private String name;

}

