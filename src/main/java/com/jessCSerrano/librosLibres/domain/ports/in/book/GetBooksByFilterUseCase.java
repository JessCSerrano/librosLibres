package com.jessCSerrano.librosLibres.domain.ports.in.book;

import com.jessCSerrano.librosLibres.domain.model.book.Book;
import com.jessCSerrano.librosLibres.domain.model.book.BookFilter;

import java.util.List;

/**
 * Interface that retrieve a list of books that match the specified filter criteria.
 * The specific implementation is found in {@link com.jessCSerrano.librosLibres.application.book.BookService}
 * This interface works with the domain model {@link Book}
 */
public interface GetBooksByFilterUseCase {

    /**
     * Retrieves a list of books that match the specified filter criteria
     *
     * @param bookFilter the filter containing the criteria to apply
     * @return a list of books that satisfy the given filter
     */
    List<Book> findBooksByFilter(BookFilter bookFilter);
}
