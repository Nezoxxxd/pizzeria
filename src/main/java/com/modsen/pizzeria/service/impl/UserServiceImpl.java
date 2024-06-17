package com.modsen.pizzeria.service.impl;

import com.modsen.pizzeria.dto.UserResponse;
import com.modsen.pizzeria.service.UserService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public UserResponse createUser(UserResponse userResponse) {
        return null;
    }

    @Override
    public UserResponse updateUser(Long id, UserResponse userResponse) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {}

    @Override
    public UserResponse getUserById(Long id) {
        return null;
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return null;
    }

}
