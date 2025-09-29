package com.jessCSerrano.librosLibres.domain.model.author;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

/**
 * Represents an author of one or more books in the bookstore system.
 */
@Entity
@Data
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
}
