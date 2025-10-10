package com.jessCSerrano.librosLibres.adapters.persistence.repository.author;

import com.jessCSerrano.librosLibres.adapters.persistence.entity.author.AuthorEntity;
import com.jessCSerrano.librosLibres.adapters.persistence.mapper.AuthorEntityMapper;
import com.jessCSerrano.librosLibres.adapters.persistence.repository.author.springdata.SpringDataAuthorRepository;
import com.jessCSerrano.librosLibres.domain.model.author.Author;
import com.jessCSerrano.librosLibres.domain.ports.out.author.AuthorRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

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
        return mapper.toDomain(
                jpaRepository.save(mapper.toEntity(author))
        );
    }

    @Override
    public List<Author> getAuthors() {
        return mapper.toDomainList(
                jpaRepository.findAll()
        );
    }
}
