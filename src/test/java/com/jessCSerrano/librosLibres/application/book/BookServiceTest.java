package com.jessCSerrano.librosLibres.application.book;

import com.jessCSerrano.librosLibres.domain.exceptions.EntityNotFoundException;
import com.jessCSerrano.librosLibres.domain.exceptions.InvalidBookPriceException;
import com.jessCSerrano.librosLibres.domain.model.author.Author;
import com.jessCSerrano.librosLibres.domain.model.author.Genre;
import com.jessCSerrano.librosLibres.domain.model.book.Book;
import com.jessCSerrano.librosLibres.domain.model.book.LiteraryGenre;
import com.jessCSerrano.librosLibres.domain.ports.out.author.AuthorRepositoryPort;
import com.jessCSerrano.librosLibres.domain.ports.out.book.BookRepositoryPort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepositoryPort bookRepositoryPort;

    @Mock
    private AuthorRepositoryPort authorRepositoryPort;

    private Book bookGiven;

    @BeforeEach
    void init() {
        bookGiven = new Book(UUID.randomUUID(),
                new Author(UUID.randomUUID(), "name", "lastName", "nationality", LocalDate.now(), Genre.FEMALE),
                "title",
                "publisher",
                LiteraryGenre.POETRY,
                new BigDecimal(20));
    }

    @Test
    void createBookWithExistingAuthor() {
        //1- Given
        Mockito.when(authorRepositoryPort.findAuthorByNames(bookGiven.author().name(), bookGiven.author().lastName())).thenReturn(Optional.ofNullable(bookGiven.author()));
        Mockito.when(bookRepositoryPort.saveBook(bookGiven)).thenReturn(bookGiven);

        //2- Act
        Book bookReturned = bookService.createBook(bookGiven);

        //3-Assert
        Assertions.assertNotNull(bookReturned);
        Assertions.assertEquals(bookGiven.title(), bookReturned.title());
        Assertions.assertEquals(bookGiven.editorial(), bookReturned.editorial());
    }

    @Test
    void createBookWithNonExistingAuthor() {
        //1- Given
        Mockito.when(authorRepositoryPort.findAuthorByNames(bookGiven.author().name(), bookGiven.author().lastName())).thenReturn(Optional.empty());
        Mockito.when(authorRepositoryPort.saveAuthor(bookGiven.author())).thenReturn(bookGiven.author());
        Mockito.when(bookRepositoryPort.saveBook(bookGiven)).thenReturn(bookGiven);

        //2- Act
        Book bookReturned = bookService.createBook(bookGiven);

        //3-Assert
        Assertions.assertNotNull(bookReturned);
        Assertions.assertEquals(bookGiven.title(), bookReturned.title());
        Assertions.assertEquals(bookGiven.editorial(), bookReturned.editorial());
    }

    @Test
    void createInvalidBookWithZeroPrice() {
        //1- Given
        Book bookInvalidPriceGiven = new Book(UUID.randomUUID(),
                new Author(UUID.randomUUID(), "name", "lastName", "nationality", LocalDate.now(), Genre.FEMALE),
                "title",
                "publisher",
                LiteraryGenre.FICTION,
                BigDecimal.ZERO);

        //2- Act & Assert
        Assertions.assertThrows(
                InvalidBookPriceException.class,
                () -> bookService.createBook(bookInvalidPriceGiven)
        );
    }

    @Test
    void createInvalidBookWithNullPrice() {
        //1- Given
        Book bookInvalidPriceGiven = new Book(UUID.randomUUID(),
                new Author(UUID.randomUUID(), "name", "lastName", "nationality", LocalDate.now(), Genre.FEMALE),
                "title",
                "publisher",
                LiteraryGenre.FICTION,
                null);

        //2- Act & Assert
        Assertions.assertThrows(
                InvalidBookPriceException.class,
                () -> bookService.createBook(bookInvalidPriceGiven)
        );
    }

    @Test
    void deleteExistingBook() {
        //1- Given
        Mockito.when(bookRepositoryPort.existsById(bookGiven.id())).thenReturn(true);

        //2- Act
        bookService.deleteBook(bookGiven.id());

        //3- Assert
        Mockito.verify(bookRepositoryPort).existsById(bookGiven.id());
        Mockito.verify(bookRepositoryPort).deleteBookById(bookGiven.id());
    }

    @Test
    void deleteNonExistingBook() {
        //1- Given
        Mockito.when(bookRepositoryPort.existsById(bookGiven.id())).thenReturn(false);

        //2- Act & Assert
        Assertions.assertThrows(
                EntityNotFoundException.class,
                () -> bookService.deleteBook(bookGiven.id())
        );

    }

}
