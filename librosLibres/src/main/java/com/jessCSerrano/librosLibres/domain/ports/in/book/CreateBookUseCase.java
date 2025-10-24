package com.jessCSerrano.librosLibres.domain.ports.in.book;

import com.jessCSerrano.librosLibres.domain.model.book.Book;

/**
 * Interface that creates a new book.
 * The specific implementation is found in {@link com.jessCSerrano.librosLibres.application.book.BookService}
 * This interface works with the domain model {@link Book}
 */
public interface CreateBookUseCase {

    Book createBook(Book book);
}
