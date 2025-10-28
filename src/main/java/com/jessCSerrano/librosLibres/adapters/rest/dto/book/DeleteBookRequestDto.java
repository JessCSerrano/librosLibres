package com.jessCSerrano.librosLibres.adapters.rest.dto.book;

import com.jessCSerrano.librosLibres.adapters.rest.dto.author.AuthorInfoRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) used to delete a book
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteBookRequestDto {
    private String name;
    private AuthorInfoRequest authorInfoRequest;
}
