package com.jessCSerrano.librosLibres.domain.model.book;

import java.math.BigDecimal;

/**
 *
 * @param maxPrice
 * @param authorName
 * @param authorLastName
 * @param editorial
 * @param literaryGenre
 */
public record BookFilter(BigDecimal maxPrice, String authorName, String authorLastName, String editorial, LiteraryGenre literaryGenre) {
}
