package com.modsen.pizzeria.mappers;

import com.modsen.pizzeria.domain.OrderStatus;
import com.modsen.pizzeria.dto.OrderStatusDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderStatusMapper {
    OrderItemMapper INSTANCE = Mappers.getMapper(OrderItemMapper.class);

    OrderStatus toModel(OrderStatusDTO orderItemDTO);

    OrderStatusDTO toDTO(OrderStatus orderItem);
}
