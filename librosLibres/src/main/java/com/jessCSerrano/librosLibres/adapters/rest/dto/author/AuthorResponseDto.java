package com.jessCSerrano.librosLibres.adapters.rest.dto.author;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Data Transfer Object (DTO) with the response author information through the REST API.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorResponseDto {
    private UUID id;
    private String name;
}
