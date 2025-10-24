package com.jessCSerrano.librosLibres.adapters.rest.dto.book;

import com.jessCSerrano.librosLibres.adapters.rest.dto.author.AuthorInfoRequest;
import com.jessCSerrano.librosLibres.domain.model.book.LiteraryGenre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Data Transfer Object (DTO) used to receive book creation data from the client
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRequestDto {
    private UUID id;
    private AuthorInfoRequest author;
    private String title;
    private String editorial;
    private LiteraryGenre literaryGenre;
    private BigDecimal price;
}
