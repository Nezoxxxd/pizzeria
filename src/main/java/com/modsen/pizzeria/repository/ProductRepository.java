package com.modsen.pizzeria.repository;

import com.modsen.pizzeria.domain.Category;
import com.modsen.pizzeria.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByCategoryId(Long categoryId);
}