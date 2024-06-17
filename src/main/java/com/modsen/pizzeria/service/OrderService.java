package com.modsen.pizzeria.service;

import com.modsen.pizzeria.dto.OrderResponse;
import java.util.List;

public interface OrderService {

    OrderResponse createOrder(OrderResponse orderResponse);

    OrderResponse updateOrder(Long id, OrderResponse orderResponse);

    void deleteOrder(Long id);

    OrderResponse getOrderById(Long id);

    List<OrderResponse> getAllOrders();

}
