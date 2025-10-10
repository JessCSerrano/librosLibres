package com.jessCSerrano.librosLibres.adapters.rest.mapper;


import com.jessCSerrano.librosLibres.adapters.rest.dto.author.AuthorRequestDto;
import com.jessCSerrano.librosLibres.adapters.rest.dto.author.AuthorResponseDto;
import com.jessCSerrano.librosLibres.domain.model.author.Author;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Mapper to convert between Author (domain) to AuthorDto (rest).
 */
@Mapper(componentModel = "spring")
public interface AuthorDtoMapper {

    Author toDomain(AuthorRequestDto authorRequestDto);

    AuthorResponseDto toResponseDto(Author author);

    List<AuthorResponseDto> toResponseDtoList(List<Author> authors);

}
