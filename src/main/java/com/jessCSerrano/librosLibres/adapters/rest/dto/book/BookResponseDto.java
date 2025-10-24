package com.jessCSerrano.librosLibres.adapters.rest.dto.book;

import com.jessCSerrano.librosLibres.adapters.rest.dto.author.AuthorResponseDto;
import com.jessCSerrano.librosLibres.domain.model.book.LiteraryGenre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Data Transfer Object (DTO) with the response book information through the REST API.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookResponseDto {
    private UUID id;
    private AuthorResponseDto author;
    private String title;
    private String editorial;
    private LiteraryGenre literaryGenre;
    private BigDecimal price;
}
