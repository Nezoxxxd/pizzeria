package com.modsen.pizzeria.service;

import com.modsen.pizzeria.dto.OrderResponse;
import com.modsen.pizzeria.dto.create.CreateOrderRequest;
import com.modsen.pizzeria.dto.update.UpdateOrderRequest;

import java.util.List;

public interface OrderService {

    OrderResponse createOrder(CreateOrderRequest createOrderRequest);

    OrderResponse updateOrder(Long id, UpdateOrderRequest updateOrderRequest);

    void deleteOrder(Long id);

    OrderResponse getOrderById(Long id);

    List<OrderResponse> getAllOrders();

}
