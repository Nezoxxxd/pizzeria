package com.modsen.pizzeria.mapper;

import com.modsen.pizzeria.domain.OrderItem;
import com.modsen.pizzeria.dto.response.OrderItemResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderItemMapper {

    OrderItemResponse toOrderItemDto(OrderItem orderItem);

    OrderItem toOrderItem(OrderItemResponse orderItemResponse);

}
