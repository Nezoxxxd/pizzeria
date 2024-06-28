package com.modsen.pizzeria.dto.request;

import com.modsen.pizzeria.domain.OrderItem;
import com.modsen.pizzeria.domain.OrderStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.util.List;


@Schema(description = "Update Order Request Dto")
public record UpdateOrderRequest(

        @NotNull(message = "{order.status.notnull}")
        OrderStatus status,

        @NotNull(message = "{order.orderItems.notnull}")
        List<OrderItem> orderItems

) {}

