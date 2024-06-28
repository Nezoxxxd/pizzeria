package com.modsen.pizzeria.dto.response;

import com.modsen.pizzeria.domain.Category;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Product Response Dto")
public record ProductResponse(

        @Schema(description = "Id", example = "1")
        Long id,

        @Schema(description = "Name", example = "Margherita")
        String name,

        @Schema(description = "Price", example = "8.99")
        Double price,

        @Schema(description = "Description", example = "Classic pizza with tomato sauce and mozzarella")
        String description,

        Category category

) {}

