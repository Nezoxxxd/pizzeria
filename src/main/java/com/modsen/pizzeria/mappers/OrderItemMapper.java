package com.modsen.pizzeria.mappers;

import com.modsen.pizzeria.domain.OrderItem;
import com.modsen.pizzeria.dto.OrderItemDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {

    OrderItemDto toOrderItemDto(OrderItem orderItem);

    OrderItem toOrderItem(OrderItemDto orderItemDto);

}
