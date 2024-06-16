package com.modsen.pizzeria.mappers;

import com.modsen.pizzeria.domain.Order;
import com.modsen.pizzeria.dto.OrderDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderDto toOrderDto(Order order);

    Order toOrder(OrderDto orderDto);

}

