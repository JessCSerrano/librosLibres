package com.jessCSerrano.librosLibres.domain.model.author;

import java.util.UUID;

/**
 * Represents an author with a name.
 */
public record Author(UUID id, String name) {
}
