package com.modsen.pizzeria.service.impl;

import com.modsen.pizzeria.domain.Order;
import com.modsen.pizzeria.domain.OrderStatus;
import com.modsen.pizzeria.dto.response.OrderResponse;
import com.modsen.pizzeria.dto.request.CreateOrderRequest;
import com.modsen.pizzeria.dto.request.UpdateOrderRequest;
import com.modsen.pizzeria.error.ErrorMessage;
import com.modsen.pizzeria.exception.InvalidOrderStatusException;
import com.modsen.pizzeria.exception.ResourceNotFoundException;
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
        Order existingOrder = findOrderByIdOrThrow(id);
        orderMapper.updateOrderFromRequest(updateOrderRequest, existingOrder);

        Order updatedOrder = orderRepository.save(existingOrder);
        return orderMapper.toOrderResponse(updatedOrder);
    }

    @Override
    public void deleteOrder(Long id) {
        Order order = findOrderByIdOrThrow(id);
        orderRepository.deleteById(id);
    }

    @Override
    public OrderResponse getOrderById(Long id) {
        Order order = findOrderByIdOrThrow(id);
        return orderMapper.toOrderResponse(order);
    }

    @Override
    public List<OrderResponse> getAllOrders() {
        return orderRepository.findAll().stream().map(orderMapper::toOrderResponse).toList();
    }

    @Override
    public OrderResponse updateOrderStatus(Long id, OrderStatus newOrderStatus) {
        Order order = findOrderByIdOrThrow(id);
        validateStatusChange(order.getStatus(), newOrderStatus);

        orderMapper.updateOrderStatus(order, newOrderStatus);

        Order updatedOrder = orderRepository.save(order);
        return orderMapper.toOrderResponse(updatedOrder);
    }

    private Order findOrderByIdOrThrow(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format(ErrorMessage.RESOURCE_NOT_FOUND, "Order", id)));
    }

    private void validateStatusChange(OrderStatus orderStatus, OrderStatus newOrderStatus) {
        if (orderStatus == OrderStatus.COMPLETED || orderStatus == OrderStatus.CANCELLED) {
            throw new InvalidOrderStatusException(ErrorMessage.COMPLETED_OR_CANCELLED_STATUS);
        }
        if (orderStatus == OrderStatus.PENDING && newOrderStatus != OrderStatus.PROCESSING) {
            throw new InvalidOrderStatusException(ErrorMessage.FROM_PENDING_TO_PROCESSING_STATUS);
        }
        if (orderStatus == OrderStatus.PROCESSING && newOrderStatus == OrderStatus.PENDING) {
            throw new InvalidOrderStatusException(ErrorMessage.FROM_PROCESSING_TO_COMPLETED_OR_CANCELLED_STATUS);
        }
    }
}