package com.jessCSerrano.librosLibres.adapters.persistence.mapper;

import com.jessCSerrano.librosLibres.adapters.persistence.entity.author.AuthorEntity;
import com.jessCSerrano.librosLibres.domain.model.author.Author;
import org.mapstruct.Mapper;

/**
 * Mapper to convert between Author (domain) and AuthorEntity (persistence).
 */
@Mapper(componentModel = "spring")
public interface AuthorEntityMapper {

    Author toDomain(AuthorEntity authorEntity);

    AuthorEntity toEntity(Author author);
}
