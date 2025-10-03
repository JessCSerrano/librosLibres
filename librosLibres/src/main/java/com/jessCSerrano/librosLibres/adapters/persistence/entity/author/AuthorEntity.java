package com.jessCSerrano.librosLibres.adapters.persistence.entity.author;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

/**
 * Represents an author of one or more books in the bookstore system.
 */
@Entity
@Data
@Table(name = "authors")
public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
}
