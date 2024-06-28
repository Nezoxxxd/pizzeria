package com.modsen.pizzeria.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Order Item Response Dto")
public record OrderItemResponse(

        @Schema(description = "Id", example = "1")
        Long id,

        ProductResponse product,

        @Schema(description = "Quantity", example = "2")
        Integer quantity

) {
}

