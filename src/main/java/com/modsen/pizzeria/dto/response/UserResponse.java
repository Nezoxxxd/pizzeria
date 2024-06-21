package com.modsen.pizzeria.dto.response;

import java.time.LocalDate;

public record UserResponse(

        Long id,

        String firstname,

        String lastname,

        String password,

        String email,

        String gender,

        LocalDate birthDate,

        RoleResponse role
) {}
