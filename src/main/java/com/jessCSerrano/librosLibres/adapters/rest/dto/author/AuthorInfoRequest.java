package com.jessCSerrano.librosLibres.adapters.rest.dto.author;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) used to receive the author's name in order to link them to the book created.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthorInfoRequest {
    private String firstName;
    private String lastName;
}
