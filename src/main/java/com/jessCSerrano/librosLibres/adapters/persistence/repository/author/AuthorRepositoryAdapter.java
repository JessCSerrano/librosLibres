package com.jessCSerrano.librosLibres.adapters.persistence.repository.author;

import com.jessCSerrano.librosLibres.adapters.persistence.entity.author.AuthorEntity;
import com.jessCSerrano.librosLibres.adapters.persistence.mapper.AuthorEntityMapper;
import com.jessCSerrano.librosLibres.adapters.persistence.repository.author.springdata.SpringDataAuthorRepository;
import com.jessCSerrano.librosLibres.domain.model.author.Author;
import com.jessCSerrano.librosLibres.domain.ports.out.author.AuthorRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * This class connects the domain with persistence using Spring Data JPA.
 * Converts between {@link Author} (domain) and {@link AuthorEntity} (persistence)
 * through {@link AuthorEntityMapper}
 */
@Repository
@RequiredArgsConstructor
public class AuthorRepositoryAdapter implements AuthorRepositoryPort {

    private final SpringDataAuthorRepository authorJpaRepository;
    private final AuthorEntityMapper authorMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    public Author saveAuthor(Author author) {
        return authorMapper.toDomain(
                authorJpaRepository.save(authorMapper.toEntity(author))
        );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Author> getAuthors() {
        return authorMapper.toDomainList(
                authorJpaRepository.findAll()
        );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Author> findAuthorByNames(String name, String lastName) {
        return authorJpaRepository.findByNameIgnoreCaseAndLastNameIgnoreCase(name, lastName)
                .map(authorMapper::toDomain);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Author> findAuthorById(UUID authorId) {
        return authorJpaRepository.findById(authorId)
                .map(authorMapper::toDomain);
    }

}
