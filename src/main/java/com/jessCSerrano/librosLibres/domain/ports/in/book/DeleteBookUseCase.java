package com.jessCSerrano.librosLibres.domain.ports.in.book;

import java.util.UUID;

/**
 * Interface that delete a book.
 * The specific implementation is found in {@link com.jessCSerrano.librosLibres.application.book.BookService}
 */
public interface DeleteBookUseCase {

    /**
     * Deletes a book by its unique identifier.
     *
     * @param bookId the unique identifier of the book to delete
     */
    void deleteBook(UUID bookId);
}
