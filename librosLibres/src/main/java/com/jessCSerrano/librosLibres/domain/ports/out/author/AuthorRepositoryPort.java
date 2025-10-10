package com.jessCSerrano.librosLibres.domain.ports.out.author;

import com.jessCSerrano.librosLibres.domain.model.author.Author;

import java.util.List;

/**
 * Port out that defines persistence operations for the Author entity.
 * The specific implementation is found in {@link com.jessCSerrano.librosLibres.adapters.persistence.repository.author.AuthorRepositoryAdapter}
 * This interface works with the domain model {@link Author}
 */
public interface AuthorRepositoryPort {

    Author save(Author author);
    List<Author> getAuthors();
}
