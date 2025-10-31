package com.jessCSerrano.librosLibres.adapters.rest.dto.author;

import com.jessCSerrano.librosLibres.domain.model.author.Genre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Data Transfer Object (DTO) used to receive author creation data from the client
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorRequestDto {
    private String name;
    private String lastName;
    private String nationality;
    private LocalDate dateOfBirth;
    private Genre genre;
}
