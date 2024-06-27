package com.modsen.pizzeria.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Category Response Dto")
public record CategoryResponse(

        @Schema(description = "Id", example = "1")
        Long id,

        @Schema(description = "Name", example = "Pizza")
        String name

) {}


