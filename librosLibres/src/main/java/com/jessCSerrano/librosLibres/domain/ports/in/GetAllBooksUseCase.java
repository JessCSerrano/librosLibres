package com.jessCSerrano.librosLibres.domain.ports.in;

import com.jessCSerrano.librosLibres.adapters.persistence.entity.book.BookEntity;

import java.util.List;

/**
 * Use case: Get all the books from the bookstore.
 * Description: Allows customers to retrieve the list of all books available in the bookstore.
 * Business rule: Sort alphabetically.
 * Inputs: None.
 * Outputs: A list of the books in the bookstore.
 */
public interface GetAllBooksUseCase {

    List<BookEntity> getAllBooks();
}
