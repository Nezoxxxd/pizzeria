package com.modsen.pizzeria.dto.request;

import com.modsen.pizzeria.domain.Category;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Schema(description = "Update Product Request Dto")
public record UpdateProductRequest(

        @NotNull(message = "{product.name.notnull}")
        @Schema(description = "Name", example = "Margherita")
        String name,

        @NotNull(message = "{product.price.notnull}")
        @Positive(message = "{product.price.positive}")
        @Schema(description = "Price", example = "8.99")
        Double price,

        @NotNull(message = "{product.description.notnull}")
        @Schema(description = "Description", example = "Classic pizza with tomato sauce and mozzarella")
        String description,

        @NotNull(message = "{product.category.notnull}")
        Category category

) {}

