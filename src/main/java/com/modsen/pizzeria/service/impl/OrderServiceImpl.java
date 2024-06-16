package com.modsen.pizzeria.service.impl;

import com.modsen.pizzeria.dto.OrderDto;
import com.modsen.pizzeria.service.OrderService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        return null;
    }

    @Override
    public OrderDto updateOrder(Long id, OrderDto orderDto) {
        return null;
    }

    @Override
    public void deleteOrder(Long id) {}

    @Override
    public OrderDto getOrderById(Long id) {
        return null;
    }

    @Override
    public List<OrderDto> getAllOrders() {
        return null;
    }

}