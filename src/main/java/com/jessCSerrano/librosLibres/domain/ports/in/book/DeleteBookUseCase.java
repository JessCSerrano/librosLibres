package com.jessCSerrano.librosLibres.domain.ports.in.book;

import com.jessCSerrano.librosLibres.domain.model.book.Book;

import java.util.UUID;

/**
 * Interface that delete a book.
 * The specific implementation is found in {@link com.jessCSerrano.librosLibres.application.book.BookService}
 * This interface works with the domain model {@link Book}
 */
public interface DeleteBookUseCase {

    /**
     * Deletes a book by its unique identifier.
     * @param bookId the unique identifier of the book to delete
     */
    void deleteBook(UUID bookId);
}
