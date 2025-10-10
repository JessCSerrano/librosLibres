package com.jessCSerrano.librosLibres.adapters.rest.dto.author;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

/**
 * Data Transfer Object (DTO) with the response author information through the REST API.
 */
public record AuthorResponseDto(UUID id, String name) {
}
