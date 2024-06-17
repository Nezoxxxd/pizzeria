package com.modsen.pizzeria.mappers;

import com.modsen.pizzeria.domain.User;
import com.modsen.pizzeria.dto.response.UserResponse;
import com.modsen.pizzeria.dto.request.CreateUserRequest;
import com.modsen.pizzeria.dto.request.UpdateUserRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponse toUserResponse(User user);

    User toUser(UserResponse userResponse);
    User toUser(CreateUserRequest createUserRequest);
    User toUser(UpdateUserRequest updateUserRequest);

}
