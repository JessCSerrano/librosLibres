package com.jessCSerrano.librosLibres.application.book;

import com.jessCSerrano.librosLibres.domain.exceptions.EntityNotFoundException;
import com.jessCSerrano.librosLibres.domain.exceptions.InvalidBookPriceException;
import com.jessCSerrano.librosLibres.domain.model.author.Author;
import com.jessCSerrano.librosLibres.domain.model.author.Genre;
import com.jessCSerrano.librosLibres.domain.model.book.Book;
import com.jessCSerrano.librosLibres.domain.model.book.BookFilter;
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
import java.util.ArrayList;
import java.util.List;
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
                BigDecimal.valueOf(20));
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
        Assertions.assertEquals(bookGiven.publisher(), bookReturned.publisher());
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
        Assertions.assertEquals(bookGiven.publisher(), bookReturned.publisher());
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

    @Test
    void updateBookExistingBookAndUpdatedAuthor() {
        //1- Given
        Book bookGivenUpdated = new Book(bookGiven.id(),
                bookGiven.author(),
                "title2",
                "publisher",
                LiteraryGenre.THRILLER,
                BigDecimal.valueOf(20));
        Mockito.when(bookRepositoryPort.findBookById(bookGiven.id())).thenReturn(Optional.ofNullable(bookGiven));
        Mockito.when(authorRepositoryPort.findAuthorByNames(bookGiven.author().name(), bookGiven.author().lastName())).thenReturn(Optional.ofNullable(bookGiven.author()));
        Mockito.when(bookRepositoryPort.saveBook(bookGivenUpdated)).thenReturn(bookGivenUpdated);

        //2- Act
        Book bookReturned = bookService.updateBook(bookGiven.id(), bookGivenUpdated);

        //3- Assert
        Assertions.assertNotNull(bookReturned);
        Assertions.assertEquals(bookGivenUpdated.author(), bookReturned.author());
        Assertions.assertEquals(bookGivenUpdated.publisher(), bookReturned.publisher());
        Assertions.assertNotEquals(bookGiven.title(), bookReturned.title());
        Assertions.assertNotEquals(bookGiven.literaryGenre(), bookReturned.literaryGenre());
    }

    @Test
    void updateBookExistingBookWithOutdatedAuthor() {
        Book bookGivenWithOutdatedAuthor = new Book(bookGiven.id(),
                null,
                "title2",
                "publisher",
                LiteraryGenre.THRILLER,
                new BigDecimal(20));
        Mockito.when(bookRepositoryPort.findBookById(bookGiven.id())).thenReturn(Optional.ofNullable(bookGiven));

        Book bookGivenWithExistingAuthor = new Book(bookGiven.id(),
                bookGiven.author(),
                "title2",
                "publisher",
                LiteraryGenre.THRILLER,
                new BigDecimal(20));
        Mockito.when(bookRepositoryPort.saveBook(bookGivenWithExistingAuthor)).thenReturn(bookGivenWithExistingAuthor);


        //2- Act
        Book bookReturned = bookService.updateBook(bookGiven.id(), bookGivenWithOutdatedAuthor);

        //Assert
        Assertions.assertEquals(bookGiven.price(), bookReturned.price());
        Assertions.assertNotEquals(bookGiven.title(), bookReturned.title());
        Assertions.assertNotEquals(bookGiven.literaryGenre(), bookReturned.literaryGenre());
    }

    @Test
    void updateBookNonExistingGivenAuthor() {
        //1-Given
        Mockito.when(bookRepositoryPort.findBookById(bookGiven.id())).thenReturn(Optional.ofNullable(bookGiven));
        Book bookGivenWithNonExistingAuthor = new Book(bookGiven.id(),
                new Author(UUID.randomUUID(), "name", "lastName", "nationality", LocalDate.now(), Genre.FEMALE),
                "title2",
                "publisher",
                LiteraryGenre.THRILLER,
                new BigDecimal(20));
        Mockito.when(authorRepositoryPort.findAuthorByNames(bookGivenWithNonExistingAuthor.author().name(), bookGivenWithNonExistingAuthor.author().lastName())).thenReturn(Optional.empty());

        //2- Act & Assert
        Assertions.assertThrows(
                EntityNotFoundException.class,
                () -> bookService.updateBook(bookGiven.id(), bookGivenWithNonExistingAuthor)
        );
    }

    @Test
    void updateBookNonExistingIdBook() {
        //1- Given me
        Book bookGivenWithNonExistingId = new Book(UUID.randomUUID(),
                bookGiven.author(),
                "title2",
                "publisher",
                LiteraryGenre.THRILLER,
                new BigDecimal(20));
        Mockito.when(bookRepositoryPort.findBookById(bookGivenWithNonExistingId.id())).thenReturn(Optional.empty());

        //2- Act & Assert
        Assertions.assertThrows(
                EntityNotFoundException.class,
                () -> bookService.updateBook(bookGivenWithNonExistingId.id(), bookGivenWithNonExistingId)
        );
    }

    @Test
    void findBooksByFilterTest() {
        //1- Given
        BookFilter bookFilterGiven = new BookFilter(
                BigDecimal.valueOf(10),
                "authorName",
                "authorLastName",
                "publisher",
                LiteraryGenre.HISTORY
        );
        List<Book> listBooksGiven = new ArrayList<>(List.of(bookGiven));
        Mockito.when(bookRepositoryPort.findBooksByFilter(bookFilterGiven)).thenReturn(listBooksGiven);

        //2- Act
        List<Book> listBookReturned = bookService.findBooksByFilter(bookFilterGiven);

        //3- Assert
        Assertions.assertEquals(listBooksGiven, listBookReturned);
    }
}
