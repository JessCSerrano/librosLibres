package com.jessCSerrano.librosLibres.adapters.rest.dto.book;

import com.jessCSerrano.librosLibres.adapters.rest.dto.author.AuthorInfoRequest;
import com.jessCSerrano.librosLibres.domain.model.book.LiteraryGenre;
import jakarta.validation.constraints.DecimalMin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Data Transfer Object (DTO) used to receive book creation data from the client
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRequestDto {
    private AuthorInfoRequest author;
    private String title;
    private String editorial;
    private LiteraryGenre literaryGenre;
    @DecimalMin(value = "0.01", message = "Price must be greater than zero")
    private BigDecimal price;
}
