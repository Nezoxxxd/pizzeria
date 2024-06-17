package com.modsen.pizzeria.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record UserResponse(

        Long id,

        String firstname,

        String lastname,

        String password,

        String email

) {}