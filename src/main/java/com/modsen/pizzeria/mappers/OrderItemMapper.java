package com.modsen.pizzeria.mappers;

import com.modsen.pizzeria.domain.OrderItem;
import com.modsen.pizzeria.dto.OrderItemDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderItemMapper {
    OrderItemMapper INSTANCE = Mappers.getMapper(OrderItemMapper.class);

    OrderItem toModel(OrderItemDTO orderItemDTO);

    OrderItemDTO toDTO(OrderItem orderItem);
}
