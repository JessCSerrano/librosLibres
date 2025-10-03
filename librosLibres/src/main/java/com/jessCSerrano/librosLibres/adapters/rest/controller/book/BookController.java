package com.jessCSerrano.librosLibres.adapters.rest.controller.book;

import com.jessCSerrano.librosLibres.application.book.BookService;
import com.jessCSerrano.librosLibres.adapters.persistence.entity.book.BookEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.net.URI;
import java.util.Collections;
import java.util.List;

@RestController
@Slf4j
@RequestMapping(path = "/books")
@RequiredArgsConstructor
@Tag(name = "Bookstore resource")
public class BookController {

    private final BookService bookService;

    /**
     * Retrieves all books from bookstore.
     *
     * @return all books from bookstore.
     */
    @Operation(summary = "get all books available in the bookstore")
    @GetMapping
    public ResponseEntity<List<BookEntity>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    //Obtener todos los títulos de los libros (distintos) por autor
    // consulta sql SELECT distinct title FROM book WHERE autor = ?;

    /**
     * Retrieves all book titles by a given author name
     *
     * @return all book titles from the bookstore by a given author name
     */
    @Operation(summary = "get all book titles by author name")
    @GetMapping("/titles")
    public ResponseEntity<List<String>> getBooksTitlesByAuthor(@RequestParam String authorName) {
        return ResponseEntity.ok(Collections.emptyList());
    }

    //Obtener precio de libro por nombre
    // SELECT price FROM book WHERE title = ?;

    /**
     * Retrieves a book price by a given title
     *
     * @param title the title of the book to look up
     * @return the price of the book
     */
    @Operation(summary = "get a book price by a given title")
    @GetMapping("/price")
    public ResponseEntity<Double> getPriceBookFromTitleBook(String title) {
        return ResponseEntity.ok(0.5);
    }

    //Añadir un nuevo libro a la librería
    //INSERT INTO book (atributos) VALUES ("valores_atributos")

    /**
     * Saves a new book in the Data Base
     *
     * @param newBookEntity the book to be created
     * @return the saved book
     */
    @Operation(summary = "saves a new book in the DB")
    @PostMapping
    public ResponseEntity<BookEntity> introduceNewBook(BookEntity newBookEntity) {
        return ResponseEntity.created(URI.create(newBookEntity.getTitle())).build();
    }

    //Cambiar precio de un libro dando su título
    //UPDATE book SET price = 15 WHERE title = ?;

    /**
     * Updates the price of a book by its given title
     *
     * @param bookName the name of the book whose price you want to change
     * @param newPrice the new price of the book
     * @return the book with the new price
     */
    @Operation(summary = "updates the price of a book by its given title")
    @PatchMapping("/price")
    public ResponseEntity<BookEntity> updateBookPrice(String bookName, BigDecimal newPrice) {
        BookEntity newBookEntity = new BookEntity();
        newBookEntity.setPrice(newPrice);
        return ResponseEntity.ok(newBookEntity);
    }

    //Borrar un libro de la base de datos, dado su nombre
    //DELETE FROM book WHERE title where = ?;

    /**
     * Deletes a book from the bookstore by its title
     *
     * @param title the name of the book to be deleted
     * @return ResponseEntity with 404 (by the moment)
     */
    @Operation(summary = "deletes a book from the bookstore by its title")
    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteBookByTitle(String title) {
        return ResponseEntity.notFound().build();
    }

    //Hacer un pedido

}
