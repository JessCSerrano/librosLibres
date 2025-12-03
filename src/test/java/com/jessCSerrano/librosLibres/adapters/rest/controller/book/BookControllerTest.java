package com.jessCSerrano.librosLibres.adapters.rest.controller.book;

import com.jessCSerrano.librosLibres.adapters.rest.dto.author.AuthorInfoRequest;
import com.jessCSerrano.librosLibres.adapters.rest.dto.author.AuthorResponseDto;
import com.jessCSerrano.librosLibres.adapters.rest.dto.book.BookFilterRequestDto;
import com.jessCSerrano.librosLibres.adapters.rest.dto.book.BookRequestDto;
import com.jessCSerrano.librosLibres.adapters.rest.dto.book.BookResponseDto;
import com.jessCSerrano.librosLibres.adapters.rest.mapper.BookDtoMapper;
import com.jessCSerrano.librosLibres.application.book.BookService;
import com.jessCSerrano.librosLibres.domain.model.author.Author;
import com.jessCSerrano.librosLibres.domain.model.author.Genre;
import com.jessCSerrano.librosLibres.domain.model.book.Book;
import com.jessCSerrano.librosLibres.domain.model.book.BookFilter;
import com.jessCSerrano.librosLibres.domain.model.book.LiteraryGenre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class BookControllerTest {

    @InjectMocks
    private BookController bookController;

    @Mock
    private BookService bookService;

    @Mock
    private BookDtoMapper dtoMapper;

    private Book bookGiven;

    private Author authorGiven;

    @BeforeEach
    void init() {
        authorGiven = new Author(UUID.randomUUID(), "firstName", "lastName", "nationality", LocalDate.now(), Genre.FEMALE);
        bookGiven = new Book(UUID.randomUUID(),
                authorGiven,
                "title",
                "publisher",
                LiteraryGenre.POETRY,
                BigDecimal.valueOf(20));
    }

    @Test
    void createBookTest() {
        //1- Given
        BookRequestDto bookRequestDtoGiven = new BookRequestDto(
                new AuthorInfoRequest("firstName", "lastName"),
                "title",
                "publisher",
                LiteraryGenre.POETRY,
                BigDecimal.valueOf(20)
        );

        BookResponseDto bookResponseDtoGiven = new BookResponseDto(
                bookGiven.id(),
                new AuthorResponseDto(authorGiven.id(), "firstName", "lastName", "nationality", LocalDate.now(), Genre.FEMALE),
                "title",
                "publisher",
                LiteraryGenre.POETRY,
                BigDecimal.valueOf(20)
        );

        Mockito.when(dtoMapper.toDomain(bookRequestDtoGiven)).thenReturn(bookGiven);
        Mockito.when(bookService.createBook(bookGiven)).thenReturn(bookGiven);
        Mockito.when(dtoMapper.toResponseDto(bookGiven)).thenReturn(bookResponseDtoGiven);

        //2- Act
        ResponseEntity<BookResponseDto> bookResponseDtoReturned = bookController.createBook(bookRequestDtoGiven);

        //3- Assert
        Assertions.assertEquals(bookResponseDtoReturned.getBody().getTitle(), bookGiven.title());
        Assertions.assertEquals(bookResponseDtoReturned.getBody().getAuthor().firstName(), bookGiven.author().firstName());
        Assertions.assertEquals(bookResponseDtoReturned.getBody().getPrice(), bookGiven.price());
    }

    @Test
    void deleteBookById() {
        //1- Given
        Mockito.doNothing().when(bookService).deleteBook(bookGiven.id());

        //2- Act
        ResponseEntity<Void> response = bookController.deleteBookById(bookGiven.id());

        //3- Assert
        Mockito.verify(bookService).deleteBook(bookGiven.id());
        Assertions.assertNull(response.getBody());
    }

    @Test
    void updateBookTest() {
        //1-Given
        BookRequestDto bookRequestDtoGiven = new BookRequestDto(
                new AuthorInfoRequest("firstName", "lastName"),
                "title",
                "publisher4",
                LiteraryGenre.POETRY,
                BigDecimal.valueOf(30)
        );

        BookResponseDto bookResponseDtoGiven = new BookResponseDto(
                bookGiven.id(),
                new AuthorResponseDto(authorGiven.id(), "firstName", "lastName", "nationality", LocalDate.now(), Genre.FEMALE),
                "title",
                "publisher4",
                LiteraryGenre.POETRY,
                BigDecimal.valueOf(30)
        );

        Mockito.when(dtoMapper.toDomain(bookRequestDtoGiven)).thenReturn(bookGiven);
        Mockito.when(bookService.updateBook(bookGiven.id(), bookGiven)).thenReturn(bookGiven);
        Mockito.when(dtoMapper.toResponseDto(bookGiven)).thenReturn(bookResponseDtoGiven);

        //2-Act
        ResponseEntity<BookResponseDto> bookResponseDtoReturned = bookController.updateBook(bookGiven.id(), bookRequestDtoGiven);

        //3-Assert
        Assertions.assertEquals(bookResponseDtoReturned.getBody().getTitle(), bookGiven.title());
        Assertions.assertNotEquals(bookResponseDtoReturned.getBody().getPublisher(), bookGiven.publisher());
        Assertions.assertNotEquals(bookResponseDtoReturned.getBody().getPrice(), bookGiven.price());
    }

    @Test
    void getBooksByFilter() {
        //1- Given
        BookFilter bookFilterGiven = new BookFilter(
                BigDecimal.valueOf(30),
                "firstName",
                "lastName",
                "publisher",
                LiteraryGenre.POETRY
        );
        BookFilterRequestDto bookFilterRequestDtoGiven = new BookFilterRequestDto(
                BigDecimal.valueOf(30),
                "firstName",
                "lastName",
                "publisher",
                LiteraryGenre.POETRY
        );

        List<Book> listBooksGiven = new ArrayList<>(List.of(bookGiven));

        Mockito.when(dtoMapper.toDomainBookFilter(bookFilterRequestDtoGiven)).thenReturn(bookFilterGiven);
        Mockito.when(bookService.findBooksByFilter(bookFilterGiven)).thenReturn(listBooksGiven);

        //2- Act
        ResponseEntity<List<Book>> listBooksReturned = bookController.getBooksByFilter(
                bookFilterRequestDtoGiven.getMaxPrice(),
                bookFilterRequestDtoGiven.getAuthorFirstName(),
                bookFilterRequestDtoGiven.getAuthorLastName(),
                bookFilterRequestDtoGiven.getPublisher(),
                bookFilterRequestDtoGiven.getLiteraryGenre()
        );

        //3- Assert
        Assertions.assertEquals(listBooksReturned.getBody(), listBooksGiven);
    }
}