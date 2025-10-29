package com.jessCSerrano.librosLibres.adapters.persistence.repository.book;

import com.jessCSerrano.librosLibres.adapters.persistence.entity.book.BookEntity;
import com.jessCSerrano.librosLibres.adapters.persistence.mapper.BookEntityMapper;
import com.jessCSerrano.librosLibres.adapters.persistence.repository.book.springdata.SpringDataBookRepository;
import com.jessCSerrano.librosLibres.domain.model.book.Book;
import com.jessCSerrano.librosLibres.domain.ports.out.book.BookRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * This class connects the domain with persistence using Spring Data JPA.
 * Converts between {@link Book} (domain) and {@link com.jessCSerrano.librosLibres.adapters.persistence.entity.book.BookEntity} (persistence)
 * through {@link BookEntityMapper}
 */
@Repository
@RequiredArgsConstructor
public class BookRepositoryAdapter implements BookRepositoryPort {

    private final SpringDataBookRepository bookJpaRepository;
    private final BookEntityMapper bookMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    public Book saveBook(Book book) {
        BookEntity bookEntity = bookMapper.toEntity(book);
        return bookMapper.toDomain(
                bookJpaRepository.save(bookEntity)
        );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteBook(UUID bookId) {
        bookJpaRepository.deleteById(bookId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean existsById(UUID bookId) {
        return bookJpaRepository.existsById(bookId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Book> findBookById(UUID bookId) {
        return bookJpaRepository.findById(bookId)
                .map(bookMapper::toDomain);
    }
}