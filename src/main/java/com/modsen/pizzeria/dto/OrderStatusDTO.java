package com.modsen.pizzeria.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
public enum OrderStatusDTO {

    PENDING("PENDING"),
    PROCESSING("PROCESSING"),
    COMPLETED("COMPLETED"),
    CANCELLED("CANCELLED");

    @NotNull(message = "Status is required")
    private final String status;

}
