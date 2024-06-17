package com.modsen.pizzeria.service.impl;

import com.modsen.pizzeria.dto.response.OrderResponse;
import com.modsen.pizzeria.dto.request.CreateOrderRequest;
import com.modsen.pizzeria.dto.request.UpdateOrderRequest;
import com.modsen.pizzeria.service.OrderService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {


    @Override
    public OrderResponse createOrder(CreateOrderRequest createOrderRequest) {return null;}

    @Override
    public OrderResponse updateOrder(Long id, UpdateOrderRequest updateOrderRequest) {return null;}

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