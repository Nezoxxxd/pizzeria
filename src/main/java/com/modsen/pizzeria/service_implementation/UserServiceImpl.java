package com.modsen.pizzeria.service_implementation;

import com.modsen.pizzeria.dto.UserDTO;
import com.modsen.pizzeria.service.UserService;
import org.springframework.stereotype.Service;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public UserDTO createUser(@Valid @NotNull UserDTO userDTO) {
        return null;
    }

    @Override
    public UserDTO updateUser(@NotNull Long id, @Valid @NotNull UserDTO userDTO) {
        return null;
    }

    @Override
    public void deleteUser(@NotNull Long id) {}

    @Override
    public UserDTO getUserById(@NotNull Long id) {
        return null;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return null;
    }

}
