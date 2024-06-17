package com.modsen.pizzeria.service;

import com.modsen.pizzeria.dto.response.UserResponse;
import com.modsen.pizzeria.dto.request.CreateUserRequest;
import com.modsen.pizzeria.dto.request.UpdateUserRequest;

import java.util.List;

public interface UserService {

    UserResponse createUser(CreateUserRequest createUserRequest);

    UserResponse updateUser(Long id, UpdateUserRequest updateUserRequest);

    void deleteUser(Long id);

    UserResponse getUserById(Long id);

    List<UserResponse> getAllUsers();

}
