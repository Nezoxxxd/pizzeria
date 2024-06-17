package com.modsen.pizzeria.mappers;

import com.modsen.pizzeria.domain.OrderItem;
import com.modsen.pizzeria.dto.response.OrderItemResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {

    OrderItemResponse toOrderItemDto(OrderItem orderItem);

    OrderItem toOrderItem(OrderItemResponse orderItemResponse);

}
