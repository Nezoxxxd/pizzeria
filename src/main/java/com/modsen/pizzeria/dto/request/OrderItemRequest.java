package com.modsen.pizzeria.dto.request;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record OrderItemRequest(


        @NotNull(message = "{orderItem.product.notnull}")
        ProductRequest product,

        @NotNull(message = "{orderItem.quantity.notnull}")
        @Positive(message = "{orderItem.quantity.positive}")
        Integer quantity
) {
}
