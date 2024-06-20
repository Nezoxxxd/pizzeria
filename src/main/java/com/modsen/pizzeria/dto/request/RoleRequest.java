package com.modsen.pizzeria.dto.request;

import jakarta.validation.constraints.NotNull;

public record RoleRequest(

        @NotNull(message = "{role.name.notnull}")
        String name

) {}
