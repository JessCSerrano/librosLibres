package com.jessCSerrano.librosLibres.application.book;

import com.jessCSerrano.librosLibres.domain.model.author.Author;
import com.jessCSerrano.librosLibres.domain.model.book.Book;
import com.jessCSerrano.librosLibres.domain.ports.in.book.CreateBookUseCase;
import com.jessCSerrano.librosLibres.domain.ports.out.author.AuthorRepositoryPort;
import com.jessCSerrano.librosLibres.domain.ports.out.book.BookRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Service that implements the business logic of Book.
 * Communicates with the domain through {@link BookRepositoryPort} to perform persistence operations.
 * Exposes methods representing use cases for the domain.
 */
@Service
@RequiredArgsConstructor
public class BookService implements CreateBookUseCase {

    private final BookRepositoryPort bookRepositoryPort;
    private final AuthorRepositoryPort authorRepositoryPort;

    @Override
    public Book createBook(Book book) {
        Author author = authorRepositoryPort.findAuthorByNames(book.author().name(), book.author().lastName())
                .orElseThrow();
        Book bookCreated = new Book(
                book.id(),
                author,
                book.title(),
                book.editorial(),
                book.literaryGenre(),
                book.price()
        );
        return bookRepositoryPort.saveBook(bookCreated);
    }
}
