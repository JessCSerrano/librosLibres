package com.jessCSerrano.librosLibres.domain.model.author;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Represents an author with a name.
 */
public record Author(UUID id, String name, String lastName, String nationality, LocalDate dateOfBirth, Genre genre) {
}
