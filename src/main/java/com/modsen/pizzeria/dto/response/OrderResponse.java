package com.modsen.pizzeria.dto.response;

import com.modsen.pizzeria.domain.OrderStatus;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "Order Response Dto")
public record OrderResponse(

        @Schema(description = "Id", example = "1")
        Long id,

        UserResponse user,

        OrderStatus status,

        List<OrderItemResponse> orderItems

) {}

