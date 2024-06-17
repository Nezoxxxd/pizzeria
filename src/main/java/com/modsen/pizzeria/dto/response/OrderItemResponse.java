package com.modsen.pizzeria.dto.response;

import com.modsen.pizzeria.domain.Order;
import com.modsen.pizzeria.domain.Product;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record OrderItemResponse(

        Long id,

        Order order,

        Product product,

        Integer quantity

) {}

