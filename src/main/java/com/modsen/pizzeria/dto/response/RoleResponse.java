package com.modsen.pizzeria.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Role Response Dto")
public record RoleResponse(

        @Schema(description = "Id", example = "2")
        Long id,

        @Schema(description = "Name", example = "Customer")
        String name

) {}
