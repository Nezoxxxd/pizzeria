package com.modsen.pizzeria.service;

import com.modsen.pizzeria.domain.OrderStatus;
import com.modsen.pizzeria.dto.response.OrderResponse;
import com.modsen.pizzeria.dto.request.CreateOrderRequest;
import com.modsen.pizzeria.dto.request.UpdateOrderRequest;

import java.util.List;

public interface OrderService {

    OrderResponse createOrder(CreateOrderRequest createOrderRequest);

    OrderResponse updateOrder(Long id, UpdateOrderRequest updateOrderRequest);

    void deleteOrder(Long id);

    OrderResponse getOrderById(Long id);

    List<OrderResponse> getAllOrders();

}
