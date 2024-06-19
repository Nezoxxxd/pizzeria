package com.modsen.pizzeria.dto.response;

import com.modsen.pizzeria.domain.Role;

import java.time.LocalDate;

public record UserResponse(

        Long id,

        String firstname,

        String lastname,

        String password,

        String email,

        String gender,

        LocalDate birthDate,

        Role role

) {}
