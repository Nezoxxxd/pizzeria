package com.modsen.pizzeria.mappers;

import com.modsen.pizzeria.domain.Order;
import com.modsen.pizzeria.domain.OrderStatus;
import com.modsen.pizzeria.dto.response.OrderResponse;
import com.modsen.pizzeria.dto.request.CreateOrderRequest;
import com.modsen.pizzeria.dto.request.UpdateOrderRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderResponse toOrderResponse(Order order);

    Order toOrder(OrderResponse orderResponse);
    Order toOrder(UpdateOrderRequest updateOrderRequest);
    Order toOrder(CreateOrderRequest createOrderRequest);

    @Mapping(target = "id", ignore = true)
    void updateOrderFromRequest(UpdateOrderRequest updateOrderRequest, @MappingTarget Order order);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "orderItems", ignore = true),
            @Mapping(target = "user", ignore = true),
    })
    void updateOrderStatus(@MappingTarget Order order, OrderStatus orderStatus);
}

