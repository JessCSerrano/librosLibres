package com.jessCSerrano.librosLibres.adapters.rest.mapper;


import com.jessCSerrano.librosLibres.adapters.rest.dto.author.AuthorDto;
import com.jessCSerrano.librosLibres.domain.model.author.Author;
import org.mapstruct.Mapper;

/**
 * Mapper to convert between Author (domain) to AuthorDto (rest).
 */
@Mapper(componentModel = "spring")
public interface AuthorDtoMapper {

    Author toDomain(AuthorDto authorDto);

    AuthorDto toDto(Author author);
}
