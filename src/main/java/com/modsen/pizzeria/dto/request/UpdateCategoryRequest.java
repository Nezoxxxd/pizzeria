package com.modsen.pizzeria.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UpdateCategoryRequest(

        @NotNull(message = "{category.name.notnull}")
        @Size(min = 2, max = 100, message = "{category.name.size}")
        String name

) {}


