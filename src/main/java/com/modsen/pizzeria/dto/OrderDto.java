package com.modsen.pizzeria.dto;

import jakarta.validation.constraints.NotNull;
import java.util.List;

public record OrderDto(

        @NotNull(message = "{order.id.notnull}")
        Long id,

        @NotNull(message = "{order.user.notnull}")
        UserDto user,

        @NotNull(message = "{order.status.notnull}")
        OrderStatusDto status,

        @NotNull(message = "{order.orderItems.notnull}")
        List<OrderItemDto> orderItems

) {}

