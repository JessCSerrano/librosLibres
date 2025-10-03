package com.jessCSerrano.librosLibres.adapters.persistence.entity.order;

import com.jessCSerrano.librosLibres.adapters.persistence.entity.book.BookEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Represents the details of a purchase made by a costumer, including books and quantities.
 */
@Entity
@Data
public class OrderDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity orderEntity;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private BookEntity bookEntity;
    private Integer quantity;
    @Column(precision = 10, scale = 2)
    private BigDecimal price;
}
