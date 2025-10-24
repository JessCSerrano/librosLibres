package com.jessCSerrano.librosLibres.domain.ports.out.book;

import com.jessCSerrano.librosLibres.domain.model.book.Book;

/**
 * Port out that defines persistence operations for the Book entity.
 * The specific implementation is found in {@link com.jessCSerrano.librosLibres.adapters.persistence.repository.book.BookRepositoryAdapter}
 * This interface works with the domain model {@link Book}
 */
public interface BookRepositoryPort {

    Book saveBook(Book book);
}
