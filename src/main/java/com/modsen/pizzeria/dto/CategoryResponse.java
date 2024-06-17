package com.modsen.pizzeria.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CategoryResponse(

        Long id,

        String name

) {}


