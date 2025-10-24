package com.jessCSerrano.librosLibres.adapters.persistence.entity.book;

import com.jessCSerrano.librosLibres.adapters.persistence.entity.author.AuthorEntity;
import com.jessCSerrano.librosLibres.domain.model.book.LiteraryGenre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Represents the main entity of the domain: a Book in the bookstore.
 */
@Entity
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "books")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @EqualsAndHashCode.Include
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private AuthorEntity authorEntity;
    @ToString.Include
    private String title;
    @ToString.Include
    private String editorial;
    @ToString.Include
    @Enumerated(value = EnumType.STRING)
    private LiteraryGenre literaryGenre;
    @ToString.Include
    @Column(precision = 10, scale = 2)
    private BigDecimal price;
}
