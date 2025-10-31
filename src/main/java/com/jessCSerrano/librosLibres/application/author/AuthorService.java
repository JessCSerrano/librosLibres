package com.jessCSerrano.librosLibres.application.author;

import com.jessCSerrano.librosLibres.domain.model.author.Author;
import com.jessCSerrano.librosLibres.domain.ports.in.author.CreateAuthorUseCase;
import com.jessCSerrano.librosLibres.domain.ports.in.author.GetAuthorsUseCase;
import com.jessCSerrano.librosLibres.domain.ports.in.author.UpdateAuthorUseCase;
import com.jessCSerrano.librosLibres.domain.ports.out.author.AuthorRepositoryPort;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Service that implements the business logic of Author.
 * Communicates with the domain through {@link AuthorRepositoryPort} to perform persistence operations.
 * Exposes methods representing use cases for the domain.
 */
@Service
@RequiredArgsConstructor
public class AuthorService implements CreateAuthorUseCase, GetAuthorsUseCase, UpdateAuthorUseCase {

    private final AuthorRepositoryPort authorRepositoryPort;

    @Override
    public Author createAuthor(Author author) {
        return authorRepositoryPort.save(author);
    }

    @Override
    public List<Author> getAuthors() {
        return authorRepositoryPort.getAuthors();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Author updateAuthor(UUID authorId, Author author) {
        Author existinAuthor = authorRepositoryPort.findAuthorById(authorId)
                .orElseThrow(EntityNotFoundException::new);
        Author updatedAuthor = new Author(
                existinAuthor.id(),
                author.name() != null ? author.name() : existinAuthor.name(),
                author.lastName() != null ? author.lastName() : existinAuthor.lastName(),
                author.nationality() != null ? author.nationality() : existinAuthor.nationality(),
                author.dateOfBirth() != null ? author.dateOfBirth() : existinAuthor.dateOfBirth(),
                author.genre() != null ? author.genre() : existinAuthor.genre()
        );
        return authorRepositoryPort.save(updatedAuthor);
    }
}
