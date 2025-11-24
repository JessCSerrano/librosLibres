package com.jessCSerrano.librosLibres.domain.model.book;

import com.jessCSerrano.librosLibres.domain.model.author.Author;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Represents a book with an identifier, author, title, publisher, literaryGenre and price.
 *
 * @param id            the unique identifier of the book
 * @param author        the author of the book
 * @param title         the title of the book
 * @param publisher     the publisher of the book
 * @param literaryGenre the literary genre of the book
 * @param price         the price of the book
 */
public record Book(UUID id, Author author, String title, String publisher, LiteraryGenre literaryGenre,
                   BigDecimal price) {
}