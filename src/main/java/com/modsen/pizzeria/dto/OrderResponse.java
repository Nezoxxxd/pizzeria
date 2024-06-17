package com.modsen.pizzeria.dto;

import jakarta.validation.constraints.NotNull;
import java.util.List;

public record OrderResponse(

        @NotNull(message = "{order.id.notnull}")
        Long id,

        @NotNull(message = "{order.user.notnull}")
        UserResponse user,

        @NotNull(message = "{order.status.notnull}")
        OrderStatusResponse status,

        @NotNull(message = "{order.orderItems.notnull}")
        List<OrderItemResponse> orderItems

) {}

