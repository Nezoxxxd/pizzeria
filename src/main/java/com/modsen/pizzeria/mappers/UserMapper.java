package com.modsen.pizzeria.mappers;

import com.modsen.pizzeria.domain.User;
import com.modsen.pizzeria.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(User user);

    User toUser(UserDto userDto);

}
