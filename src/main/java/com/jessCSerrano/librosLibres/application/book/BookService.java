package com.jessCSerrano.librosLibres.application.book;

import com.jessCSerrano.librosLibres.domain.model.author.Author;
import com.jessCSerrano.librosLibres.domain.model.book.Book;
import com.jessCSerrano.librosLibres.domain.ports.in.book.CreateBookUseCase;
import com.jessCSerrano.librosLibres.domain.ports.in.book.DeleteBookUseCase;
import com.jessCSerrano.librosLibres.domain.ports.in.book.UpdateBookUseCase;
import com.jessCSerrano.librosLibres.domain.ports.out.author.AuthorRepositoryPort;
import com.jessCSerrano.librosLibres.domain.ports.out.book.BookRepositoryPort;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.UUID;

/**
 * Service that implements the business logic of Book.
 * Communicates with the domain through {@link BookRepositoryPort} to perform persistence operations.
 * Exposes methods representing use cases for the domain.
 */
@Service
@RequiredArgsConstructor
public class BookService implements CreateBookUseCase, DeleteBookUseCase, UpdateBookUseCase {

    private final BookRepositoryPort bookRepositoryPort;
    private final AuthorRepositoryPort authorRepositoryPort;

    /**
     * {@inheritDoc}
     */
    @Override
    public Book createBook(Book book) {
        Author author = authorRepositoryPort.findAuthorByNames(book.author().name(), book.author().lastName())
                .orElseGet(() -> authorRepositoryPort.save(book.author()));
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

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteBook(UUID bookId) {
        if (!bookRepositoryPort.existsById(bookId)) {
            throw new EntityNotFoundException();
        }
        bookRepositoryPort.deleteBook(bookId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Book updateBook(UUID bookId, Book book) {
        Book existingBook = bookRepositoryPort.findBookById(bookId).orElseThrow(() -> new NoSuchElementException("Book not found with id: " + bookId));
        Author authorToUse;
        if (book.author() != null && book.author().name() != null && !book.author().name().isBlank() &&
                book.author().lastName() != null && !book.author().lastName().isBlank()) {
            authorToUse = authorRepositoryPort.findAuthorByNames(book.author().name(), book.author().lastName())
                    .orElseThrow(EntityNotFoundException::new);
        } else {
            authorToUse = existingBook.author();
        }
        Book updatedBook = new Book(
                existingBook.id(),
                authorToUse,
                book.title() != null ? book.title() : existingBook.title(),
                book.editorial() != null ? book.editorial() : existingBook.editorial(),
                book.literaryGenre() != null ? book.literaryGenre() : existingBook.literaryGenre(),
                book.price() != null ? book.price() : existingBook.price()
        );
        return bookRepositoryPort.saveBook(updatedBook);
    }
}
