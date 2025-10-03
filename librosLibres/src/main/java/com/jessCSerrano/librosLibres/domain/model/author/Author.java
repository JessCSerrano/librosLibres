package com.jessCSerrano.librosLibres.domain.model.author;

import lombok.Getter;

/**
 * Represents an author with a name.
 * If the provided name is null or blank, the author name will default to "Anónimo"
 * Instances  of this class are created using the static factory method {@link #create(String)}.
 */
@Getter
public class Author {
    private static final String DEFAULT_NAME = "Anónimo";
    private final String name;

    private Author(String name) {
        this.name = (name == null || name.isBlank()) ? DEFAULT_NAME : name;
    }

    public static Author create(String name) {
        return new Author(name);
    }
}
