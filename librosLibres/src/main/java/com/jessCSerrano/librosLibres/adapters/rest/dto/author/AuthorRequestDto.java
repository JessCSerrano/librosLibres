package com.jessCSerrano.librosLibres.adapters.rest.dto.author;

import com.jessCSerrano.librosLibres.domain.model.author.Genre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
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
    private String lastName;
    private String nationality;
    private LocalDate dateOfBirth;
    private Genre genre;
}
