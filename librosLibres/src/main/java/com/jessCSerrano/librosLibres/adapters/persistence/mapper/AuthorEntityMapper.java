package com.jessCSerrano.librosLibres.adapters.persistence.mapper;

import com.jessCSerrano.librosLibres.adapters.persistence.entity.author.AuthorEntity;
import com.jessCSerrano.librosLibres.domain.model.author.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper to convert between Author (domain) and AuthorEntity (persistence).
 */
@Mapper(componentModel = "spring")
public interface AuthorEntityMapper {

    default Author toDomain(AuthorEntity authorEntity) {
        if (authorEntity == null) return null;
        return Author.create(authorEntity.getName());
    }

    default AuthorEntity toEntity(Author author) {
        if (author == null) return null;
        AuthorEntity entity = new AuthorEntity();
        entity.setName(author.getName());
        return entity;
    }
}
