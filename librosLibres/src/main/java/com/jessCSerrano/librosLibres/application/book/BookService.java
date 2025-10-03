package com.jessCSerrano.librosLibres.application.book;

import com.jessCSerrano.librosLibres.adapters.persistence.entity.book.BookEntity;
import com.jessCSerrano.librosLibres.domain.ports.in.book.GetAllBooksUseCase;
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
    public List<BookEntity> getAllBooks() {
        var elPrincipito = new BookEntity();
        elPrincipito.setTitle("El principito");
        var harryPotter = new BookEntity();
        harryPotter.setTitle("Harry Potter");
        return new ArrayList<>(List.of(elPrincipito, harryPotter));
    }
}
