package com.modsen.pizzeria.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;

@Schema(description = "User Response Dto")
public record UserResponse(

        @Schema(description = "Id", example = "1")
        Long id,

        @Schema(description = "First Name", example = "John")
        String firstname,

        @Schema(description = "Last Name", example = "Doe")
        String lastname,

        @Schema(description = "Password", example = "password1")
        String password,

        @Schema(description = "Email", example = "john.doe@example.com")
        String email,

        @Schema(description = "Gender", example = "Male")
        String gender,

        @Schema(description = "Birth Date", example = "1999-01-02")
        LocalDate birthDate,

        RoleResponse role
) {}
