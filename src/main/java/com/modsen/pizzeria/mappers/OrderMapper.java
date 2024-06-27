package com.modsen.pizzeria.mappers;

import com.modsen.pizzeria.domain.Order;
import com.modsen.pizzeria.dto.response.OrderResponse;
import com.modsen.pizzeria.dto.request.CreateOrderRequest;
import com.modsen.pizzeria.dto.request.UpdateOrderRequest;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderMapper {

    OrderResponse toOrderResponse(Order order);

    Order toOrder(OrderResponse orderResponse);

    Order toOrder(UpdateOrderRequest updateOrderRequest);

    Order toOrder(CreateOrderRequest createOrderRequest);

}

