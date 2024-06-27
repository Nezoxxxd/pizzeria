package com.modsen.pizzeria.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Schema(description = "Create User Request Dto")
public record CreateUserRequest(

        @NotNull(message = "{user.firstname.notnull}")
        @Schema(description = "First Name", example = "John")
        String firstname,

        @NotNull(message = "{user.lastname.notnull}")
        @Schema(description = "Last Name", example = "Doe")
        String lastname,

        @NotNull(message = "{user.password.notnull}")
        @Schema(description = "Password", example = "password1")
        String password,

        @Email(message = "{user.email.valid}")
        @Schema(description = "Email", example = "john.doe@example.com")
        @NotNull(message = "{user.email.notnull}")
        String email,

        @NotNull(message = "{user.gender.notnull}")
        @Schema(description = "Gender", example = "Male")
        String gender,

        @NotNull(message = "{user.birthDate.notnull}")
        @Schema(description = "Birth Date", example = "1999-01-02")
        LocalDate birthDate

) {}
