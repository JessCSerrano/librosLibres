package com.jessCSerrano.librosLibres.domain.ports.in.author;

import com.jessCSerrano.librosLibres.domain.model.author.Author;

import java.util.List;

/**
 * Interface that bring all authors.
 * The specific implementation is found in {@link com.jessCSerrano.librosLibres.application.author.AuthorService}
 * This interface works with the domain model {@link Author}
 */
public interface GetAuthorsUseCase {

    /**
     * Retrieves all authors stored in the system.
     *
     * @return a list containing all existing authors
     */
    List<Author> getAuthors();

}