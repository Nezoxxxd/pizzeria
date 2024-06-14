package com.modsen.pizzeria.mappers;

import com.modsen.pizzeria.domain.OrderStatus;
import com.modsen.pizzeria.dto.OrderStatusDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderStatusMapper {

    OrderStatusMapper INSTANCE = Mappers.getMapper(OrderStatusMapper.class);

    OrderStatusDTO toOrderStatusDTO(OrderStatus orderStatus);

    OrderStatus toOrderStatus(OrderStatusDTO orderStatusDTO);

}
