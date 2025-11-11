package com.jessCSerrano.librosLibres.domain.ports.out.book;

import com.jessCSerrano.librosLibres.domain.model.book.Book;
import com.jessCSerrano.librosLibres.domain.model.book.BookFilter;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Port out that defines persistence operations for the Book entity.
 * The specific implementation is found in {@link com.jessCSerrano.librosLibres.adapters.persistence.repository.book.BookRepositoryAdapter}
 * This interface works with the domain model {@link Book}
 */
public interface BookRepositoryPort {

    /**
     * Saves a book.
     *
     * @param book the object to be saved.
     * @return the saved {@link  Book} with the assigned UUID
     */
    Book saveBook(Book book);

    /**
     * Deletes a book for the given ID.
     *
     * @param bookId the unique identifier of the book to delete.
     */
    void deleteBookById(UUID bookId);

    /**
     * Checks whether a book exists for the given ID.
     *
     * @param bookId the unique identifier of the book to check.
     * @return true if the book exists, false otherwise.
     */
    boolean existsById(UUID bookId);

    /**
     * Searches for a book using its unique identifier.
     *
     * @param bookId the unique identifier of the book to search for
     * @return an {@link Optional} containing the {@link Book} if found, or an empty {@code Optional} if no book exists with the given identifier
     */
    Optional<Book> findBookById(UUID bookId);

    /**
     * Retrieves a list of books that match the specified filter criteria.
     *
     * @param bookFilter the filter containing the criteria to apply
     * @return a list of books that satisfy the given filter
     */
    List<Book> findBooksByFilter(BookFilter bookFilter);

}
