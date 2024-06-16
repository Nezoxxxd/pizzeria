package com.modsen.pizzeria.dto;

import lombok.Getter;

@Getter
public enum OrderStatusDto {
    PENDING,
    PROCESSING,
    COMPLETED,
    CANCELLED
}
