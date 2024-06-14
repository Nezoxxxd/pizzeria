package com.modsen.pizzeria.dto;

import lombok.Data;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class OrderDTO {

    @NotNull(message = "ID is required")
    private Long id;

    @NotNull(message = "User is required")
    private UserDTO user;

    @NotNull(message = "Order status is required")
    private OrderStatusDTO status;

    @NotNull(message = "Order items are required")
    private List<OrderItemDTO> orderItems;

}

