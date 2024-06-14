package com.modsen.pizzeria.dto;

import lombok.Data;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
public class UserDTO {

    @NotNull(message = "ID is required")
    private Long id;

    @NotNull(message = "First Name is required")
    private String firstname;

    @NotNull(message = "Last Name is required")
    private String lastname;

    @NotNull(message = "Password is required")
    private String password;

    @Email(message = "Email should be valid")
    @NotNull(message = "Email is required")
    private String email;

}
