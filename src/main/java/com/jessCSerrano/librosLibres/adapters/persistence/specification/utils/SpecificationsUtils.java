package com.jessCSerrano.librosLibres.adapters.persistence.specification.utils;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;

import java.util.List;

/**
 * Utility class that provides methods for building JPA specifications.
 */
public class SpecificationsUtils {

    private SpecificationsUtils() {
    }

    /**
     * Adds a {@code LIKE} predicate to the given list if the specified value is not null or blank.
     *
     * @param value           the value to evaluate and include in the predicate
     * @param predicates      the list of predicates to which the new condition will be added
     * @param criteriaBuilder the CriteriaBuilder used to construct the predicate
     * @param path            representing the entity attribute to apply the filter on
     */
    public static void addLikeIfPresent(
            String value, List<Predicate> predicates,
            CriteriaBuilder criteriaBuilder,
            Path<String> path) {
        if (value != null && !value.isBlank()) {
            predicates.add(
                    criteriaBuilder.like(
                            criteriaBuilder.lower(path),
                            "%" + value.toLowerCase() + "%"));
        }
    }
}
