package com.jessCSerrano.librosLibres.domain.model.book;

import java.math.BigDecimal;

/**
 * Represents a book filter with parameters such as max price, author first name, author last name publisher and literary genre for searching books.
 *
 * @param maxPrice        set the max price of the books, shows books with a lower price than the given number
 * @param authorFirstName shows books written by this author (first name)
 * @param authorLastName  shows books witten by this author (last name)
 * @param publisher       shows books published by this publisher
 * @param literaryGenre   shows books belonging to this literary genre
 */
public record BookFilter(BigDecimal maxPrice, String authorFirstName, String authorLastName, String publisher,
                         LiteraryGenre literaryGenre) {
}
