package com.modsen.pizzeria.dto.response;


public record OrderItemResponse(

        Long id,

        ProductResponse product,

        Integer quantity

) {
}

