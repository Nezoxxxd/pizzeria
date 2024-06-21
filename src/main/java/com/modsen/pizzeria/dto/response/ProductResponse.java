package com.modsen.pizzeria.dto.response;

import com.modsen.pizzeria.domain.Category;

public record ProductResponse(

        Long id,

        String name,

        Double price,

        String description,

        Category category

) {}

