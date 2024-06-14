package com.modsen.pizzeria.dto;

import com.modsen.pizzeria.domain.Order;
import com.modsen.pizzeria.domain.Product;
import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class OrderItemDTO {

    @NotNull(message = "Product ID is required")
    private Long id;

    @NotNull(message = "Order is required")
    private Order order;

    @NotNull(message = "Product is required")
    private Product product;

    @NotNull(message = "Quantity is required")
    @Positive(message = "Quantity must be positive")
    private Integer quantity;

}

