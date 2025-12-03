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
     * Saves an author.
     *
     * @param author the object to be saved
     * @return the saved {@link Author} with the assigned UUID
     */
    Author saveAuthor(Author author);

    /**
     * Retrieves all the authors.
     *
     * @return a list containing all existing authors
     */
    List<Author> getAuthors();

    /**
     * Searches for an author by their firstName and last firstName.
     *
     * @param firstName     the firstName of the author to search for
     * @param lastName the last firstName of the author to search for
     * @return an {@link Optional} containing the {@link Author} if found, or an empty {@code Optional} if no author exists with the given firstName and last firstName
     */
    Optional<Author> findAuthorByName(String firstName, String lastName);

    /**
     * Searches for an author by their unique identifier.
     *
     * @param authorId the unique identifier of the author to search for
     * @return an {@link Optional} containing the {@link Author} if found, or an empty {@code Optional} if no author exists with the given identifier
     */
    Optional<Author> findAuthorById(UUID authorId);

    /**
     * Deletes an author.
     * This operation also removes all books associated with the author.
     *
     * @param authorId the unique identifier of the author to delete.
     */
    void deleteAuthorById(UUID authorId);

    /**
     * Checks if an author exists for the given ID.
     *
     * @param authorId the unique identifier of the author to check.
     * @return true if the author exists, false otherwise.
     */
    boolean existsById(UUID authorId);
}
