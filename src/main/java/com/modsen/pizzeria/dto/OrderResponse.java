package com.modsen.pizzeria.dto;

import com.modsen.pizzeria.domain.OrderItem;
import com.modsen.pizzeria.domain.OrderStatus;
import com.modsen.pizzeria.domain.User;
import java.util.List;

public record OrderResponse(

        Long id,

        User user,

        OrderStatus status,

        List<OrderItem> orderItems

) {}

