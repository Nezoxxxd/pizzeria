package com.modsen.pizzeria.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class OrderStatusDTO {

    @NotBlank(message = "Order status is required")
    private String status;

}
