package com.jessCSerrano.librosLibres.domain.ports.in.author;

import com.jessCSerrano.librosLibres.domain.model.author.Author;

/**
 * Interface that creates a new author.
 * The specific implementation is found in {@link com.jessCSerrano.librosLibres.application.author.AuthorService}
 * This interface works with the domain model {@link Author}
 */
public interface CreateAuthorUseCase {

    /**
     * Creates a new author in the system.
     *
     * @param author object containing the details of the author to be created
     * @return the created {@link Author}
     */
    Author createAuthor(Author author);

}