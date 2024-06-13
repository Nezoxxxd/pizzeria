package com.modsen.pizzeria.service;

import com.modsen.pizzeria.dto.UserDTO;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface UserService {

    UserDTO createUser(@Valid @NotNull UserDTO userDTO);

    UserDTO updateUser(@NotNull Long id, @Valid @NotNull UserDTO userDTO);

    void deleteUser(@NotNull Long id);

    UserDTO getUserById(@NotNull Long id);

    List<UserDTO> getAllUsers();

}
