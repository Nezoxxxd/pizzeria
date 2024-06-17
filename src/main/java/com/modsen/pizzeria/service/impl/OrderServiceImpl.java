package com.modsen.pizzeria.service.impl;

import com.modsen.pizzeria.dto.OrderResponse;
import com.modsen.pizzeria.service.OrderService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public OrderResponse createOrder(OrderResponse orderResponse) {
        return null;
    }

    @Override
    public OrderResponse updateOrder(Long id, OrderResponse orderResponse) {
        return null;
    }

    @Override
    public void deleteOrder(Long id) {}

    @Override
    public OrderResponse getOrderById(Long id) {
        return null;
    }

    @Override
    public List<OrderResponse> getAllOrders() {
        return null;
    }

}