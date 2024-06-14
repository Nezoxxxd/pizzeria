package com.modsen.pizzeria.Repository;

import com.modsen.pizzeria.domain.Category;
import com.modsen.pizzeria.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(Category category);
}
