package com.jessCSerrano.librosLibres.adapters.rest.dto.author;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) to expose author information through the REST API.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorRequestDto {
    private String name;
}
