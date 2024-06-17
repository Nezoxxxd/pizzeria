package com.modsen.pizzeria.dto.response;

import com.modsen.pizzeria.domain.Category;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProductResponse(

        Long id,

        String name,

        Double price,

        String description,

        Category category

) {}

