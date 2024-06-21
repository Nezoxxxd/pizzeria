package com.modsen.pizzeria.dto.response;

import com.modsen.pizzeria.domain.Order;
import com.modsen.pizzeria.domain.Product;

public record OrderItemResponse(

        Long id,

        Order order,

        Product product,

        Integer quantity

) {}

