package com.jessCSerrano.librosLibres.domain.ports.out.book;

import com.jessCSerrano.librosLibres.domain.model.book.Book;

import java.util.UUID;

/**
 * Port out that defines persistence operations for the Book entity.
 * The specific implementation is found in {@link com.jessCSerrano.librosLibres.adapters.persistence.repository.book.BookRepositoryAdapter}
 * This interface works with the domain model {@link Book}
 */
public interface BookRepositoryPort {

    /**
     * Saves a book in the persistence system.
     *
     * @param book the object to be saved.
     * @return the saved {@link  Book} with the assigned UUID.
     */
    Book saveBook(Book book);

    /**
     * Deletes a book from the persistence system.
     *
     * @param bookId the unique identifier of the book to delete.
     */
    void deleteBook(UUID bookId);

    /**
     * Checks if a book exists in the persistence system for the given ID.
     *
     * @param bookId the unique identifier of the book to check.
     * @return true if the book exists, false otherwise.
     */
    boolean existsById(UUID bookId);
}
