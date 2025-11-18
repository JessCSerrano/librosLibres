package com.jessCSerrano.librosLibres.adapters.rest.exception;

import com.jessCSerrano.librosLibres.domain.exceptions.EntityNotFoundException;
import com.jessCSerrano.librosLibres.domain.exceptions.InvalidBookPriceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Handles all the exceptions in the application in a centralized way.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles {@link InvalidBookPriceException}.
     * <p>
     * This exception is thrown when the book price is less than or equal to zero.
     *
     * @param invalidBookPriceException the exception to handle
     * @return a {@link ResponseEntity} containing the HTTP status {@link HttpStatus#BAD_REQUEST} and a descriptive message
     */
    @ExceptionHandler(InvalidBookPriceException.class)
    public ResponseEntity<String> handleInvalidBookPrice(InvalidBookPriceException invalidBookPriceException) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(invalidBookPriceException.getMessage());
    }

    /**
     * Handles {@link EntityNotFoundException}.
     * <p>
     * This exception is thrown when an entity cannot be found.
     *
     * @param entityNotFoundException the exception to handle
     * @return a {@link ResponseEntity} containing the HTTP status {@link HttpStatus#NOT_FOUND} and a descriptive message
     */
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFound(EntityNotFoundException entityNotFoundException) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(entityNotFoundException.getMessage());
    }
}
