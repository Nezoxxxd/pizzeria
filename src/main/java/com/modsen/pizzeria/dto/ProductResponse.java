package com.modsen.pizzeria.dto;

import com.modsen.pizzeria.domain.Category;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProductResponse(

        @NotNull(message = "{product.id.notnull}")
        Long id,

        @NotNull(message = "{product.name.notnull}")
        String name,

        @NotNull(message = "{product.price.notnull}")
        @Positive(message = "{product.price.positive}")
        Double price,

        @NotNull(message = "{product.description.notnull}")
        String description,

        @NotNull(message = "{product.category.notnull}")
        Category category

) {}

