package com.modsen.pizzeria.service_implementation;

import com.modsen.pizzeria.dto.OrderDTO;
import com.modsen.pizzeria.service.OrderService;
import org.springframework.stereotype.Service;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public OrderDTO createOrder(@Valid @NotNull OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO updateOrder(@NotNull Long id, @Valid @NotNull OrderDTO orderDTO) {
        return null;
    }

    @Override
    public void deleteOrder(@NotNull Long id) {}

    @Override
    public OrderDTO getOrderById(@NotNull Long id) {
        return null;
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        return null;
    }

}