package com.modsen.pizzeria.mappers;

import com.modsen.pizzeria.domain.User;
import com.modsen.pizzeria.dto.UserResponse;
import com.modsen.pizzeria.dto.create.CreateOrderRequest;
import com.modsen.pizzeria.dto.create.CreateUserRequest;
import com.modsen.pizzeria.dto.update.UpdateProductRequest;
import com.modsen.pizzeria.dto.update.UpdateUserRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponse toUserResponse(User user);

    User toUser(UserResponse userResponse);
    User toUser(CreateUserRequest createUserRequest);
    User toUser(UpdateUserRequest updateUserRequest);

}
