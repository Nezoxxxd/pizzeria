package com.modsen.pizzeria.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "products")
@Schema(description = "Product Entity")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Id", example = "1")
    private Long id;

    @Column(nullable = false, length = 100)
    @Schema(description = "Name", example = "Margherita")
    private String name;

    @Column(columnDefinition = "TEXT")
    @Schema(description = "Description", example = "Classic pizza with tomato sauce and mozzarella")
    private String description;

    @Column(nullable = false, precision = 10, scale = 2)
    @Schema(description = "Price", example = "8.99")
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    @Schema(description = "Category Id", example = "1")
    private Category category;

}
