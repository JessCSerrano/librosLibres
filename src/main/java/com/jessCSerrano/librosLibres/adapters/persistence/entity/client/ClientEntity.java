package com.jessCSerrano.librosLibres.adapters.persistence.entity.client;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

/**
 * Represents a customer who purchases books in the bookstore.
 */
@Entity
@Data
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String email;
}
