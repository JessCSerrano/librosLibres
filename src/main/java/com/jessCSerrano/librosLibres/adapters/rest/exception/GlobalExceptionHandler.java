package com.jessCSerrano.librosLibres.adapters.rest.exception;

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
     *
     * @param invalidBookPriceException the exception to handle
     * @return a {@link ResponseEntity} containing the HTTP status and a descriptive message
     */
    @ExceptionHandler(InvalidBookPriceException.class)
    public ResponseEntity<String> handleInvalidBookPrice(InvalidBookPriceException invalidBookPriceException) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(invalidBookPriceException.getMessage());
    }
}
