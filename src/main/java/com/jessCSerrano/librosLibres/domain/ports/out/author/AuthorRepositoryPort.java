package com.jessCSerrano.librosLibres.domain.ports.out.author;

import com.jessCSerrano.librosLibres.domain.model.author.Author;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Port out that defines persistence operations for the Author entity.
 * The specific implementation is found in {@link com.jessCSerrano.librosLibres.adapters.persistence.repository.author.AuthorRepositoryAdapter}
 * This interface works with the domain model {@link Author}
 */
public interface AuthorRepositoryPort {

    /**
     * Saves an author in the persistence system.
     *
     * @param author the object to be saved
     * @return the saved {@link Author} with the assigned UUID
     */
    Author saveAuthor(Author author);

    /**
     * Retrieves all the author stored in the persistence system.
     *
     * @return a list containing all existing authors
     */
    List<Author> getAuthors();

    /**
     * Searches for an author in the persistence system by their name and last name.
     *
     * @param name     the name of the author to search for
     * @param lastName the last name of the author to search for
     * @return an {@link Optional} containing the {@link Author} if found, or an empty {@code Optional} if no author exists with the given name and last name
     */
    Optional<Author> findAuthorByNames(String name, String lastName);

    /**
     * Searches for an author in the persistence system by their unique identifier.
     *
     * @param authorId the unique identifier of the author to search for
     * @return an {@link Optional} containing the {@link Author} if found, or an empty {@code Optional} if no author exists with the given identifier
     */
    Optional<Author> findAuthorById(UUID authorId);
}
