package com.modsen.pizzeria.service;

import com.modsen.pizzeria.dto.response.UserResponse;
import com.modsen.pizzeria.dto.request.UpdateUserRequest;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public interface UserService {

    UserResponse updateUser(Long id, UpdateUserRequest updateUserRequest);

    void deleteUser(Long id);

    UserResponse getUserById(Long id);

    List<UserResponse> getAllUsers();

    UserResponse me(HttpServletRequest request);

}
