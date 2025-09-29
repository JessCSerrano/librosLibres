package com.jessCSerrano.librosLibres.domain.model.book;

import com.jessCSerrano.librosLibres.domain.model.author.Author;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

/**
 * Represents the main entity of the domain: a Book in the bookstore.
 */
@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
    private String title;
    private String editorial;
    @Enumerated(value = EnumType.STRING)
    private Genre genre;
    private Double price;
}
