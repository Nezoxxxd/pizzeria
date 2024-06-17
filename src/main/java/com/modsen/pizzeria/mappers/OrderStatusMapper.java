package com.modsen.pizzeria.mappers;

import com.modsen.pizzeria.domain.OrderStatus;
import com.modsen.pizzeria.dto.OrderStatusResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderStatusMapper {

    OrderStatusResponse toOrderStatusDto(OrderStatus orderStatus);

    OrderStatus toOrderStatus(OrderStatusResponse orderStatusResponse);

}
