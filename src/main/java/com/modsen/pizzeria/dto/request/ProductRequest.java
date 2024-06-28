package com.modsen.pizzeria.dto.request;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProductRequest(

        @NotNull(message = "{product.id.notnull}")
        Long id,

        @NotNull(message = "{product.name.notnull}")
        String name,

        @NotNull(message = "{orderItem.price.notnull}")
        @Positive(message = "{orderItem.price.positive}")
        Double price,

        @NotNull(message = "{product.description.notnull}")
        String description,

        @NotNull(message = "{product.category.notnull}")
        CreateCategoryRequest category

) {
}

