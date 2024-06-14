package com.modsen.pizzeria.mappers;

import com.modsen.pizzeria.domain.Order;
import com.modsen.pizzeria.dto.OrderDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order toModel(OrderDTO orderDTO);

    OrderDTO toDTO(Order order);

}

