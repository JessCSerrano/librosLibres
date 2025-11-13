package com.jessCSerrano.librosLibres.domain.exceptions;

/**
 * Exception thrown when a book has an invalid price.
 * Extends {@link RuntimeException}
 */
public class InvalidBookPriceException extends RuntimeException {

    /**
     * Constructs a new InvalidBookPriceException with the specified detail message.
     *
     * @param message the detail message explaining the reason for the exception
     */
    public InvalidBookPriceException(String message) {
        super(message);
    }
}
