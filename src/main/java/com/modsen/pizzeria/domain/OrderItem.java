package com.modsen.pizzeria.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "orderItems")
@Schema(description = "Order Item Entity")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Id", example = "1")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    @Schema(description = "Order Id", example = "1")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    @Schema(description = "Product Id", example = "1")
    private Product product;

    @Column(nullable = false)
    @Schema(description = "Quantity", example = "2")
    private Integer quantity;

}
