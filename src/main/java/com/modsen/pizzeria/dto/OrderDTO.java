package com.modsen.pizzeria.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class OrderDTO {

    private Long id;

    @NotNull(message = "User ID is required")
    private Long userId;

    @NotNull(message = "Order items are required")
    private List<OrderItemDTO> items;

    @NotNull(message = "Order status is required")
    private OrderStatusDTO status;

}

