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
     * @param id     the id to search
     */
    public EntityNotFoundException(String entity, UUID id) {
        super(String.format("%s with id %s was not found", entity, id));
    }

    /**
     * Constructs a new EntityNotFoundException with the specified detail message.
     * Indicating that an author with specified first name and last name was not found.
     *
     * @param firstName the author's first name that was not found
     * @param lastName  the author's last name that was not found
     */
    public EntityNotFoundException(String firstName, String lastName) {
        super(String.format("The author with first name %s and last last name %s was not found", firstName, lastName));
    }
}
