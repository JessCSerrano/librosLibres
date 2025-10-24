package com.jessCSerrano.librosLibres.application.author;

import com.jessCSerrano.librosLibres.domain.model.author.Author;
import com.jessCSerrano.librosLibres.domain.ports.in.author.CreateAuthorUseCase;
import com.jessCSerrano.librosLibres.domain.ports.in.author.GetAuthorsUseCase;
import com.jessCSerrano.librosLibres.domain.ports.out.author.AuthorRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service that implements the business logic of Author.
 * Communicates with the domain through {@link AuthorRepositoryPort} to perform persistence operations.
 * Exposes methods representing use cases for the domain.
 */
@Service
@RequiredArgsConstructor
public class AuthorService implements CreateAuthorUseCase, GetAuthorsUseCase {

    private final AuthorRepositoryPort authorRepositoryPort;

    @Override
    public Author createAuthor(Author author) {
        return authorRepositoryPort.save(author);
    }

   @Override
    public List<Author> getAuthors() {
        return authorRepositoryPort.getAuthors();
    }
}
