package com.jessCSerrano.librosLibres.adapters.persistence.mapper;

import com.jessCSerrano.librosLibres.adapters.persistence.entity.author.AuthorEntity;
import com.jessCSerrano.librosLibres.domain.model.author.Author;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Mapper to convert between Author (domain) and AuthorEntity (persistence).
 */
@Mapper(componentModel = "spring")
public interface AuthorEntityMapper {

    Author toDomain(AuthorEntity authorEntity);

    List<Author> toDomainList(List<AuthorEntity> authors);

    AuthorEntity toEntity(Author author);
}
