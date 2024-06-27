package com.modsen.pizzeria.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Schema(description = "Update Category Request Dto")
public record UpdateCategoryRequest(

        @NotNull(message = "{category.name.notnull}")
        @Size(min = 2, max = 100, message = "{category.name.size}")
        @Schema(description = "Name", example = "Pizza")
        String name

) {}


