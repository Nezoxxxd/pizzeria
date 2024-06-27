package com.modsen.pizzeria.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Role Request Dto")
public record RoleRequest(

        @NotNull(message = "{role.name.notnull}")
        @Schema(description = "Name", example = "Admin")
        String name

) {}
