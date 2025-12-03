package com.jessCSerrano.librosLibres.domain.model.author;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Represents an author with an identifier first name, last name, nationality, date of birth and genre.
 *
 * @param id          the unique identifier of the author
 * @param firstName   the first name of the author
 * @param lastName    the last name of the author
 * @param nationality the nationality of the author
 * @param dateOfBirth the date of birth of the author
 * @param genre       the genre of the book
 */
public record Author(UUID id, String firstName, String lastName, String nationality, LocalDate dateOfBirth,
                     Genre genre) {
}
