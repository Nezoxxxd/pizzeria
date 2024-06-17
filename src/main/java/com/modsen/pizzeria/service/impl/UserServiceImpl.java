package com.modsen.pizzeria.service.impl;

import com.modsen.pizzeria.domain.User;
import com.modsen.pizzeria.dto.response.UserResponse;
import com.modsen.pizzeria.dto.request.CreateUserRequest;
import com.modsen.pizzeria.dto.request.UpdateUserRequest;
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
            // todo throw InvalidInputException
        }

        if(userRepository.findByEmail(createUserRequest.email()) != null) {
            // todo throw DuplicateResourceException
        }

        User user = userMapper.toUser(createUserRequest);
        return userMapper.toUserResponse(userRepository.save(user));
    }

    @Override
    public UserResponse updateUser(Long id, UpdateUserRequest updateUserRequest) {
        if(!updateUserRequest.email().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
            // todo throw InvalidInputException
        }

        User existingUser = userRepository.findById(id)
                .orElseThrow();

        if(existingUser.getEmail().equals(updateUserRequest.email()) ||
                (userRepository.findByEmail(updateUserRequest.email()) == null)) {
            existingUser.setEmail(updateUserRequest.email());
        } else {
            // todo throw InvalidInputException
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
                .orElseThrow();

        userRepository.deleteById(id);
    }

    @Override
    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow();
        return userMapper.toUserResponse(user);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        List<User> user = userRepository.findAll();
        return user.stream().map(userMapper::toUserResponse).toList();
    }

}
