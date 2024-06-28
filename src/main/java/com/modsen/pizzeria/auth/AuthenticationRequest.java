package com.modsen.pizzeria.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Auth Request request")
public record AuthenticationRequest(

        @Email(message = "{user.email.valid}")
        @NotNull(message = "{user.email.notnull}")
        @Schema(description = "Email", example = "john.doe@example.com")
        String email,

        @NotNull(message = "{user.password.notnull}")
        @Schema(description = "Password", example = "password1")
        String password

) {
}
