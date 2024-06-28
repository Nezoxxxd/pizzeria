package com.modsen.pizzeria.dto.request;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CreateOrderRequest(

        @NotNull(message = "{order.orderItems.notnull}")
        List<OrderItemRequest> orderItems

) {}

