package com.modsen.pizzeria.service;

import com.modsen.pizzeria.dto.OrderDto;
import java.util.List;

public interface OrderService {

    OrderDto createOrder(OrderDto orderDto);

    OrderDto updateOrder(Long id, OrderDto orderDto);

    void deleteOrder(Long id);

    OrderDto getOrderById(Long id);

    List<OrderDto> getAllOrders();

}
