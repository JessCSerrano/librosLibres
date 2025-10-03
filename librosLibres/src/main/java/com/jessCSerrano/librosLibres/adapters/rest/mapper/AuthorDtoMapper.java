package com.jessCSerrano.librosLibres.adapters.rest.mapper;


import com.jessCSerrano.librosLibres.adapters.persistence.entity.author.AuthorEntity;
import com.jessCSerrano.librosLibres.adapters.rest.dto.author.AuthorRequestDto;
import com.jessCSerrano.librosLibres.adapters.rest.dto.author.AuthorResponseDto;
import com.jessCSerrano.librosLibres.domain.model.author.Author;
import org.mapstruct.Mapper;

/**
 * Mapper to convert between Author (domain) to AuthorDto (rest).
 */
@Mapper(componentModel = "spring")
public interface AuthorDtoMapper {

    default Author toDomain(AuthorRequestDto authorRequestDto) {
        if (authorRequestDto == null) return null;
        return Author.create(authorRequestDto.getName());
    }

    AuthorRequestDto toRequestDto(Author author);

    AuthorResponseDto toResponseDto(AuthorEntity authorEntity);

}
