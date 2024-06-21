package com.modsen.pizzeria.mappers;

import com.modsen.pizzeria.domain.Role;
import com.modsen.pizzeria.domain.User;
import com.modsen.pizzeria.dto.response.UserResponse;
import com.modsen.pizzeria.dto.request.CreateUserRequest;
import com.modsen.pizzeria.dto.request.UpdateUserRequest;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {RoleMapper.class})
public interface UserMapper {

    @Mapping(target = "role", source = "role")
    UserResponse toUserResponse(User user);

    User toUser(UserResponse userResponse);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "role", source = "role")
    })
    User toUser(CreateUserRequest createUserRequest, Role role);

    @Mapping(target = "id", ignore = true)
    User toUser(UpdateUserRequest updateUserRequest);

    @Mapping(target = "id", ignore = true)
    void updateUserFromRequest(UpdateUserRequest updateUserRequest, @MappingTarget User user);

}
