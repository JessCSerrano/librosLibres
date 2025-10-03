package com.jessCSerrano.librosLibres.domain.ports.in.author;

import com.jessCSerrano.librosLibres.domain.model.author.Author;

/**
 *
 */
public interface CreateAuthorUseCase {

    Author createAuthor(Author author);
}