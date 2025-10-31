package com.jessCSerrano.librosLibres.domain.ports.in.author;

import com.jessCSerrano.librosLibres.domain.model.author.Author;

import java.util.UUID;

/**
 * Interface for updating an author.
 * The specific implementation is found in {@link com.jessCSerrano.librosLibres.application.author.AuthorService}
 * This interface works with the domain model {@link Author}
 */
public interface UpdateAuthorUseCase {

    /**
     * Updates an author by their unique identifier and the new values provided for the author.
     *
     * @param authorId the unique identifier of the author
     * @param author   the new data for the author
     * @return the updated author
     */
    Author updateAuthor(UUID authorId, Author author);

}
