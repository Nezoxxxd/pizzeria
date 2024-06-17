package com.modsen.pizzeria.dto.update;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UpdateCategoryRequest(

        @NotNull(message = "{category.id.notnull}")
        Long id,

        @NotNull(message = "{category.name.notnull}")
        @Size(min = 2, max = 100, message = "{category.name.size}")
        String name

) {}


