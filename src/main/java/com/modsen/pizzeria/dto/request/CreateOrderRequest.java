package com.modsen.pizzeria.dto.request;

import com.modsen.pizzeria.domain.OrderItem;
import com.modsen.pizzeria.domain.User;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Schema(description = "Create Order Request Dto")
public record CreateOrderRequest(

        @NotNull(message = "{order.orderItems.notnull}")
        List<OrderItemRequest> orderItems

) {}

