package com.modsen.pizzeria.dto.response;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CategoryResponse(

        Long id,

        String name

) {}


