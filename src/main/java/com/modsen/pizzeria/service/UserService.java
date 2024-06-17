package com.modsen.pizzeria.service;

import com.modsen.pizzeria.dto.UserResponse;
import com.modsen.pizzeria.dto.create.CreateUserRequest;
import com.modsen.pizzeria.dto.update.UpdateUserRequest;

import java.util.List;

public interface UserService {

    UserResponse createUser(CreateUserRequest createUserRequest);

    UserResponse updateUser(Long id, UpdateUserRequest updateUserRequest);

    void deleteUser(Long id);

    UserResponse getUserById(Long id);

    List<UserResponse> getAllUsers();

}
