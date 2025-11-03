package com.jessCSerrano.librosLibres.domain.ports.in.author;

import java.util.UUID;

/**
 * Interface that delete a book.
 * The specific implementation is found in {@link com.jessCSerrano.librosLibres.application.author.AuthorService}
 */
public interface DeleteAuthorUseCase {

    /**
     * Deletes an author using their unique identifier.
     * This operation also removes all books associated with the author.
     *
     * @param authorId the unique identifier of the author to delete
     */
    void deleteAuthorById(UUID authorId);
}
