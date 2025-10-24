package com.jessCSerrano.librosLibres.adapters.persistence.mapper;

import com.jessCSerrano.librosLibres.adapters.persistence.entity.book.BookEntity;
import com.jessCSerrano.librosLibres.domain.model.book.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper to convert between Book (domain) and BookEntity (persistence).
 */
@Mapper(componentModel = "spring", uses = AuthorEntityMapper.class)
public interface BookEntityMapper {

    @Mapping(source = "authorEntity", target = "author")
    Book toDomain(BookEntity bookEntity);

    @Mapping(source = "author", target = "authorEntity")
    BookEntity toEntity(Book book);
}
