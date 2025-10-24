package com.jessCSerrano.librosLibres.adapters.rest.mapper;

import com.jessCSerrano.librosLibres.adapters.rest.dto.book.BookRequestDto;
import com.jessCSerrano.librosLibres.adapters.rest.dto.book.BookResponseDto;
import com.jessCSerrano.librosLibres.domain.model.book.Book;
import org.mapstruct.Mapper;

/**
 * Mapper to convert between Book (domain) to BookDto (rest).
 */
@Mapper(componentModel = "spring")
public interface BookDtoMapper {

    BookResponseDto toResponseDto(Book book);

    Book toDomain(BookRequestDto bookRequestDto);
}