package com.modsen.pizzeria.dto.response;

import com.modsen.pizzeria.domain.OrderStatus;
import java.util.List;

public record OrderResponse(

        Long id,

        OrderStatus status,

        List<OrderItemResponse> orderItems

) {}

