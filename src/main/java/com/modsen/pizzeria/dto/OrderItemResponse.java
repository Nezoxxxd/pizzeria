package com.modsen.pizzeria.dto;

import com.modsen.pizzeria.domain.Order;
import com.modsen.pizzeria.domain.Product;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record OrderItemResponse(

        @NotNull(message = "{orderItem.id.notnull}")
        Long id,

        @NotNull(message = "{orderItem.order.notnull}")
        Order order,

        @NotNull(message = "{orderItem.product.notnull}")
        Product product,

        @NotNull(message = "{orderItem.quantity.notnull}")
        @Positive(message = "{orderItem.quantity.positive}")
        Integer quantity

) {}

