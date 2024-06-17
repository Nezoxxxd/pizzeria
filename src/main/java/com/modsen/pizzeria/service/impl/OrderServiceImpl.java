package com.modsen.pizzeria.service.impl;

import com.modsen.pizzeria.domain.Order;
import com.modsen.pizzeria.domain.OrderStatus;
import com.modsen.pizzeria.dto.response.OrderResponse;
import com.modsen.pizzeria.dto.request.CreateOrderRequest;
import com.modsen.pizzeria.dto.request.UpdateOrderRequest;
import com.modsen.pizzeria.mappers.OrderMapper;
import com.modsen.pizzeria.repository.OrderRepository;
import com.modsen.pizzeria.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Override
    public OrderResponse createOrder(CreateOrderRequest createOrderRequest) {
        Order order = orderMapper.toOrder(createOrderRequest);
        order.setStatus(OrderStatus.PENDING);
        return orderMapper.toOrderResponse(orderRepository.save(order));
    }

    @Override
    public OrderResponse updateOrder(Long id, UpdateOrderRequest updateOrderRequest) {
        Order existingOrder = orderRepository.findById(id)
                .orElseThrow();

        existingOrder.setStatus(updateOrderRequest.status());
        existingOrder.setOrderItems( updateOrderRequest.orderItems());

        Order updatesOrder = orderRepository.save(existingOrder);
        return orderMapper.toOrderResponse(updatesOrder);
    }

    @Override
    public void deleteOrder(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow();

        orderRepository.deleteById(id);
    }

    @Override
    public OrderResponse getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow();

        return orderMapper.toOrderResponse(order);
    }

    @Override
    public List<OrderResponse> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream().map(orderMapper::toOrderResponse).toList();
    }

}