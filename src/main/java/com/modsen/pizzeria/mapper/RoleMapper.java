package com.modsen.pizzeria.mapper;

import com.modsen.pizzeria.domain.Role;
import com.modsen.pizzeria.dto.request.RoleRequest;
import com.modsen.pizzeria.dto.response.RoleResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RoleMapper {

    RoleResponse toRoleResponse(Role role);

    Role toRole(RoleRequest roleRequest);

}
