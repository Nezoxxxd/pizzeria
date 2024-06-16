package com.modsen.pizzeria.service;

import com.modsen.pizzeria.dto.UserDto;
import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDto);

    UserDto updateUser(Long id, UserDto userDto);

    void deleteUser(Long id);

    UserDto getUserById(Long id);

    List<UserDto> getAllUsers();

}
