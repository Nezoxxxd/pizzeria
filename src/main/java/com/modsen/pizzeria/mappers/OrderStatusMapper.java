package com.modsen.pizzeria.mappers;

import com.modsen.pizzeria.domain.OrderStatus;
import com.modsen.pizzeria.dto.OrderStatusDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderStatusMapper {

    OrderStatusDto toOrderStatusDto(OrderStatus orderStatus);

    OrderStatus toOrderStatus(OrderStatusDto orderStatusDto);

}
