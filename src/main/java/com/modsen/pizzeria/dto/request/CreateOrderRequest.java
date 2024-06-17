package com.modsen.pizzeria.dto.request;

import com.modsen.pizzeria.domain.OrderItem;
import com.modsen.pizzeria.domain.User;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CreateOrderRequest(

        @NotNull(message = "{order.user.notnull}")
        User user,

        @NotNull(message = "{order.orderItems.notnull}")
        List<OrderItem> orderItems

) {}

