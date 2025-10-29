package com.jessCSerrano.librosLibres.domain.ports.in.book;

import com.jessCSerrano.librosLibres.domain.model.book.Book;

import java.util.UUID;

/**
 * Interface for updating a book.
 * The specific implementation is found in {@link com.jessCSerrano.librosLibres.application.book.BookService}
 * This interface works with the domain model {@link Book}
 */
public interface UpdateBookUseCase {

    /**
     * Updates a book using its unique identifier and the new values provided for the book.
     *
     * @param bookId the unique identifier of the book
     * @param book   the new data for the book
     * @return the updated book
     */
    Book updateBook(UUID bookId, Book book);
}
