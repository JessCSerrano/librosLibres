package com.jessCSerrano.librosLibres.domain.ports.out.author;

import com.jessCSerrano.librosLibres.domain.model.author.Author;
import com.jessCSerrano.librosLibres.domain.model.book.Book;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Port out that defines persistence operations for the Author entity.
 * The specific implementation is found in {@link com.jessCSerrano.librosLibres.adapters.persistence.repository.author.AuthorRepositoryAdapter}
 * This interface works with the domain model {@link Author}
 */
public interface AuthorRepositoryPort {

    Author save(Author author);

    List<Author> getAuthors();

    Optional<Author> findAuthorByNames(String name, String lastName);

    /**
     * Searches for an author in the persistence system using its unique identifier.
     *
     * @param authorId the unique identifier of the author to search for
     * @return an {@link Optional} containing the {@link Author} if found, or an empty {@code Optional} if no author exists with the given identifier
     */
    Optional<Author> findAuthorById(UUID authorId);
}
