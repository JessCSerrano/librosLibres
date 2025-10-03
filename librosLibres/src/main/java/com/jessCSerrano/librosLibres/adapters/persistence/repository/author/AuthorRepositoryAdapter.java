package com.jessCSerrano.librosLibres.adapters.persistence.repository.author;

import com.jessCSerrano.librosLibres.adapters.persistence.entity.author.AuthorEntity;
import com.jessCSerrano.librosLibres.adapters.persistence.mapper.AuthorEntityMapper;
import com.jessCSerrano.librosLibres.adapters.persistence.repository.author.springdata.SpringDataAuthorRepository;
import com.jessCSerrano.librosLibres.domain.model.author.Author;
import com.jessCSerrano.librosLibres.domain.ports.out.author.AuthorRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * This class connects the domain with persistence using Spring Data JPA.
 * Converts between {@link Author} (domain) and {@link AuthorEntity} (persistence)
 * through {@link AuthorEntityMapper}
 */
@Repository
@RequiredArgsConstructor
public class AuthorRepositoryAdapter implements AuthorRepositoryPort {

    private final SpringDataAuthorRepository jpaRepository;
    private final AuthorEntityMapper mapper;

    @Override
    public Author save(Author author) {
        AuthorEntity authorEntity = mapper.toEntity(author);
        AuthorEntity savedAuthor = jpaRepository.save(authorEntity);
        return mapper.toDomain(savedAuthor);
    }
}
