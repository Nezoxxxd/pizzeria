package com.modsen.pizzeria.service;

import com.modsen.pizzeria.dto.OrderDTO;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface OrderService {

    OrderDTO createOrder(@Valid @NotNull OrderDTO orderDTO);

    OrderDTO updateOrder(@NotNull Long id, @Valid @NotNull OrderDTO orderDTO);

    void deleteOrder(@NotNull Long id);

    OrderDTO getOrderById(@NotNull Long id);

    List<OrderDTO> getAllOrders();

}
