package com.modsen.pizzeria.mappers;

import com.modsen.pizzeria.domain.Order;
import com.modsen.pizzeria.dto.OrderResponse;
import com.modsen.pizzeria.dto.create.CreateOrderRequest;
import com.modsen.pizzeria.dto.update.UpdateOrderRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderResponse toOrderResponse(Order order);

    Order toOrder(OrderResponse orderResponse);
    Order toOrder(UpdateOrderRequest updateOrderRequest);
    Order toOrder(CreateOrderRequest createOrderRequest);

}

