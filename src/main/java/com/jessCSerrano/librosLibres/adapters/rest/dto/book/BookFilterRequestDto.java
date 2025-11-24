package com.jessCSerrano.librosLibres.adapters.rest.dto.book;

import com.jessCSerrano.librosLibres.domain.model.book.LiteraryGenre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Data Transfer Object (DTO) used to receive filter parameters for searching books.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookFilterRequestDto {
    private BigDecimal maxPrice;
    private String authorName;
    private String authorLastName;
    private String publisher;
    private LiteraryGenre literaryGenre;
}
