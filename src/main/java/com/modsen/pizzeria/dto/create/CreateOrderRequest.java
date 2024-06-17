package com.modsen.pizzeria.dto.create;

import com.modsen.pizzeria.dto.OrderItemResponse;
import com.modsen.pizzeria.dto.OrderStatusResponse;
import com.modsen.pizzeria.dto.UserResponse;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CreateOrderRequest(

        @NotNull(message = "{order.user.notnull}")
        UserResponse user,

        @NotNull(message = "{order.status.notnull}")
        OrderStatusResponse status,

        @NotNull(message = "{order.orderItems.notnull}")
        List<OrderItemResponse> orderItems

) {}

