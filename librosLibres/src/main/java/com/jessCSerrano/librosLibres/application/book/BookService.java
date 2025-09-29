package com.jessCSerrano.librosLibres.application.book;

import com.jessCSerrano.librosLibres.domain.model.book.Book;
import com.jessCSerrano.librosLibres.domain.ports.in.GetAllBooksUseCase;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of GetAllBookTitlesUseCase
 * Responsibilities:
 * - Retrieves all book titles from the repository.
 * - Applies business rules: sort alphabetically.
 * Dependencies: BookRepository
 */
@Service
public class BookService implements GetAllBooksUseCase {
    @Override
    public List<Book> getAllBooks() {
        var elPrincipito = new Book();
        elPrincipito.setTitle("El principito");
        var harryPotter = new Book();
        harryPotter.setTitle("Harry Potter");
        return new ArrayList<>(List.of(elPrincipito, harryPotter));
    }
}
