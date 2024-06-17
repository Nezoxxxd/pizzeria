package com.modsen.pizzeria.service;

import com.modsen.pizzeria.dto.UserResponse;
import java.util.List;

public interface UserService {

    UserResponse createUser(UserResponse userResponse);

    UserResponse updateUser(Long id, UserResponse userResponse);

    void deleteUser(Long id);

    UserResponse getUserById(Long id);

    List<UserResponse> getAllUsers();

}
