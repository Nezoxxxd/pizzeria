package com.modsen.pizzeria.Repository;

import com.modsen.pizzeria.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
