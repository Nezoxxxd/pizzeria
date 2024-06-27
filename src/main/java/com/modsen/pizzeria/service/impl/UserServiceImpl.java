package com.modsen.pizzeria.service.impl;

import com.modsen.pizzeria.auth.EmailMatchOrAdminAccess;
import com.modsen.pizzeria.domain.Role;
import com.modsen.pizzeria.domain.RoleName;
import com.modsen.pizzeria.domain.User;
import com.modsen.pizzeria.dto.response.UserResponse;
import com.modsen.pizzeria.dto.request.CreateUserRequest;
import com.modsen.pizzeria.dto.request.UpdateUserRequest;
import com.modsen.pizzeria.error.ErrorMessages;
import com.modsen.pizzeria.exception.DuplicateResourceException;
import com.modsen.pizzeria.exception.ResourceNotFoundException;
import com.modsen.pizzeria.mappers.UserMapper;
import com.modsen.pizzeria.repository.RoleRepository;
import com.modsen.pizzeria.repository.UserRepository;
import com.modsen.pizzeria.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;


    @Override
    public UserResponse createUser(CreateUserRequest createUserRequest) {
        checkUserExistence(createUserRequest.email());
        Role defaultRole = findRoleByName(RoleName.CUSTOMER);
        User user = userMapper.toUser(createUserRequest, defaultRole);
        user.setPassword(passwordEncoder.encode(createUserRequest.password()));
        return userMapper.toUserResponse(userRepository.save(user));
    }

    @Override
    @EmailMatchOrAdminAccess
    public UserResponse updateUser(Long id, UpdateUserRequest updateUserRequest) {
        User existingUser = findUserByIdOrThrow(id);
        userMapper.updateUserFromRequest(updateUserRequest, existingUser);
        User updatedUser = userRepository.save(existingUser);
        return userMapper.toUserResponse(updatedUser);
    }

    @Override
    @EmailMatchOrAdminAccess
    public void deleteUser(Long id) {
        User user = findUserByIdOrThrow(id);
        userRepository.deleteById(id);
    }

    @Override
    @EmailMatchOrAdminAccess
    public UserResponse getUserById(Long id) {
        User user = findUserByIdOrThrow(id);
        return userMapper.toUserResponse(user);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toUserResponse)
                .toList();
    }

    private User findUserByIdOrThrow(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format(ErrorMessages.RESOURCE_NOT_FOUND_MESSAGE, "User", id)));
    }

    private Role findRoleByName(RoleName roleName) {
        return roleRepository.findByName(roleName)
                .orElseThrow(() -> new ResourceNotFoundException(String.format(ErrorMessages.ROLE_NOT_FOUND_MESSAGE, roleName)));
    }

    private void checkUserExistence(String email) {
        if (userRepository.existsByEmail(email)) {
            throw new DuplicateResourceException(String.format(ErrorMessages.DUPLICATE_RESOURCE_MESSAGE, "User", "email"));
        }
    }
}
