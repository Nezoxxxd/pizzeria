package com.modsen.pizzeria.dto.create;

import com.modsen.pizzeria.domain.OrderItem;
import com.modsen.pizzeria.domain.OrderStatus;
import com.modsen.pizzeria.domain.User;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CreateOrderRequest(

        @NotNull(message = "{order.user.notnull}")
        User user,

        @NotNull(message = "{order.status.notnull}")
        OrderStatus status,

        @NotNull(message = "{order.orderItems.notnull}")
        List<OrderItem> orderItems

) {}

