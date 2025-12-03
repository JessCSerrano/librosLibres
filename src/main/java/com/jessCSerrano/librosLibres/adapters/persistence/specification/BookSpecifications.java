package com.jessCSerrano.librosLibres.adapters.persistence.specification;

import com.jessCSerrano.librosLibres.adapters.persistence.entity.author.AuthorEntity;
import com.jessCSerrano.librosLibres.adapters.persistence.entity.book.BookEntity;
import com.jessCSerrano.librosLibres.adapters.persistence.specification.utils.SpecificationsUtils;
import com.jessCSerrano.librosLibres.domain.model.book.BookFilter;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

/**
 * Provides Specification for filtering {@link BookEntity} records.
 * This class dynamically builds query predicates using the JPA Criteria API.
 */
public class BookSpecifications {

    /**
     * This method creates a list of predicates using the JPA Criteria API.
     *
     * @param bookFilter an object containing the filter parameters
     * @return a {@link Specification} that can be used with {@link org.springframework.data.jpa.repository.JpaSpecificationExecutor}
     * to retrieve books matching the specified filter criteria
     */
    public static Specification<BookEntity> withFilters(BookFilter bookFilter) {

        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (bookFilter.maxPrice() != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("price"), bookFilter.maxPrice()));
            }

            if (bookFilter.authorFirstName() != null && !bookFilter.authorFirstName().isBlank() ||
                    bookFilter.authorLastName() != null && !bookFilter.authorLastName().isBlank()) {

                Join<BookEntity, AuthorEntity> authorJoin = root.join("authorEntity", JoinType.INNER);

                SpecificationsUtils.addLikeIfPresent(bookFilter.authorFirstName(), predicates, criteriaBuilder, authorJoin.get("firstName"));
                SpecificationsUtils.addLikeIfPresent(bookFilter.authorLastName(), predicates, criteriaBuilder, authorJoin.get("lastName"));
            }

            SpecificationsUtils.addLikeIfPresent(bookFilter.publisher(), predicates, criteriaBuilder, root.get("publisher"));

            if (bookFilter.literaryGenre() != null) {
                predicates.add(criteriaBuilder.equal(root.get("literaryGenre"), bookFilter.literaryGenre()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
