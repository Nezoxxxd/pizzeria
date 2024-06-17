package com.modsen.pizzeria.service.impl;

import com.modsen.pizzeria.domain.User;
import com.modsen.pizzeria.dto.response.UserResponse;
import com.modsen.pizzeria.dto.request.CreateUserRequest;
import com.modsen.pizzeria.dto.request.UpdateUserRequest;
import com.modsen.pizzeria.exception.DuplicateResourceException;
import com.modsen.pizzeria.exception.InvalidInputException;
import com.modsen.pizzeria.exception.ResourceNotFoundException;
import com.modsen.pizzeria.mappers.UserMapper;
import com.modsen.pizzeria.repository.UserRepository;
import com.modsen.pizzeria.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponse createUser(CreateUserRequest createUserRequest) {
        if(!createUserRequest.email().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
            throw new InvalidInputException("Invalid email address");
        }

        if(userRepository.findByEmail(createUserRequest.email()) != null) {
            throw new DuplicateResourceException("User with this email already exists");
        }

        User user = userMapper.toUser(createUserRequest);
        return userMapper.toUserResponse(userRepository.save(user));
    }

    @Override
    public UserResponse updateUser(Long id, UpdateUserRequest updateUserRequest) {
        if(!updateUserRequest.email().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
            throw new InvalidInputException("Invalid email address");
        }

        User existingUser = userRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException("User with id " + id + " does not exist"));

        if(existingUser.getEmail().equals(updateUserRequest.email()) ||
                (userRepository.findByEmail(updateUserRequest.email()) == null)) {
            existingUser.setEmail(updateUserRequest.email());
        } else {
            throw new DuplicateResourceException("User with this email already exists");
        }
        existingUser.setFirstname(updateUserRequest.firstname());
        existingUser.setLastname(updateUserRequest.lastname());
        existingUser.setPassword(updateUserRequest.password());

        User updatedUser = userRepository.save(existingUser);
        return userMapper.toUserResponse(updatedUser);
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException("User with id " + id + " does not exist") );

        userRepository.deleteById(id);
    }

    @Override
    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException("User with id " + id + " does not exist") );
        return userMapper.toUserResponse(user);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        List<User> user = userRepository.findAll();
        return user.stream().map(userMapper::toUserResponse).toList();
    }

}
