package com.jessCSerrano.librosLibres.adapters.rest.dto.author;

import com.jessCSerrano.librosLibres.domain.model.author.Genre;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Data Transfer Object (DTO) with the response author information through the REST API.
 */
public record AuthorResponseDto(UUID id, String name, String lastName, String nationality, LocalDate dateOfBirth,
                                Genre genre) {
}