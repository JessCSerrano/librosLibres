package com.jessCSerrano.librosLibres.domain.exceptions;

import java.util.UUID;

/**
 * Exception thrown when an entity has not found.
 * Extends {@link RuntimeException}
 */
public class EntityNotFoundException extends RuntimeException {

    /**
     * Constructs a new EntityNotFoundException with the specified detail message.
     *
     * @param entity the entity that not be found
     * @param id the id to search
     */
    public EntityNotFoundException(String entity, UUID id) {
        super(String.format("%s with id %s was not found", entity, id));
    }
}
