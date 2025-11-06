package com.jessCSerrano.librosLibres.adapters.persistence.specification;

import com.jessCSerrano.librosLibres.adapters.persistence.entity.author.AuthorEntity;
import com.jessCSerrano.librosLibres.adapters.persistence.entity.book.BookEntity;
import com.jessCSerrano.librosLibres.domain.model.book.BookFilter;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class BookSpecifications {

    public static Specification<BookEntity> withFilters(BookFilter bookFilter) {

        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (bookFilter.maxPrice() != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("price"), bookFilter.maxPrice()));
            }

            if (bookFilter.authorName() != null && !bookFilter.authorName().isBlank() ||
                    bookFilter.authorLastName() != null && !bookFilter.authorLastName().isBlank()) {

                Join<BookEntity, AuthorEntity> authorJoin = root.join("authorEntity", JoinType.INNER);

                if (bookFilter.authorName() != null && !bookFilter.authorName().isBlank()) {
                    predicates.add(criteriaBuilder.like(criteriaBuilder.lower(authorJoin.get("name")),
                            "%" + bookFilter.authorName().toLowerCase() + "%"));
                }
                if (bookFilter.authorLastName() != null && !bookFilter.authorLastName().isBlank()) {
                    predicates.add(criteriaBuilder.like(criteriaBuilder.lower(authorJoin.get("lastName")),
                            "%" + bookFilter.authorLastName() + "%"));
                }
            }

            if (bookFilter.editorial() != null && !bookFilter.editorial().isBlank()) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("editorial")),
                        "%" + bookFilter.editorial().toLowerCase() + "%"));
            }

            if (bookFilter.literaryGenre() != null) {
                predicates.add(criteriaBuilder.equal(root.get("literaryGenre"), bookFilter.literaryGenre()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

    }
}
