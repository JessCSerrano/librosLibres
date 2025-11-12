package com.jessCSerrano.librosLibres.domain.service;

import com.jessCSerrano.librosLibres.domain.model.book.Book;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Validates the parameters used to create a book.
 */
@Component
public class BookValidator {

    /**
     * Method to validate a price of book. This price must be greater than zero.
     *
     * @param book the book to validate (during creation)
     */
    public void validateBook(Book book) {
        if (book.price() == null || book.price().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Book price must be greater than zero");
        }
    }
}
