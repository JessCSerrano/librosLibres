package com.jessCSerrano.librosLibres.domain.model.order;

import com.jessCSerrano.librosLibres.domain.model.book.Book;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

/**
 * Represents the details of a purchase made by a costumer, including books and quantities.
 */
@Entity
@Data
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    private Integer quantity;
    private Double price;
}
