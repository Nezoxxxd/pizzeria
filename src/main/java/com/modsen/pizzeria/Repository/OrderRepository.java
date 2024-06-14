package com.modsen.pizzeria.Repository;

import com.modsen.pizzeria.domain.Order;
import com.modsen.pizzeria.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUser(User user);
}
