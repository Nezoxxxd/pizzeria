package com.modsen.pizzeria.Repository;

import com.modsen.pizzeria.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
