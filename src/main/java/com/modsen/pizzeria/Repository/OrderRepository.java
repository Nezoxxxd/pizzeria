package com.modsen.pizzeria.Repository;

import com.modsen.pizzeria.domain.Order;
import com.modsen.pizzeria.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUser(User user);
}