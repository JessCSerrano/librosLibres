package com.jessCSerrano.librosLibres.adapters.persistence.entity.book;

import com.jessCSerrano.librosLibres.adapters.persistence.entity.author.AuthorEntity;
import com.jessCSerrano.librosLibres.domain.model.book.LiteraryGenre;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Represents the main entity of the domain: a Book in the bookstore.
 */
@Entity
@Data
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private AuthorEntity authorEntity;
    private String title;
    private String editorial;
    @Enumerated(value = EnumType.STRING)
    private LiteraryGenre literaryGenre;
    @Column(precision = 10, scale = 2)
    private BigDecimal price;
}
