package com.jessCSerrano.librosLibres.adapters.rest.dto.author;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Data Transfer Object (DTO) to expose author information through the REST API.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorRequestDto {
    private UUID id;
    private String name;
}
