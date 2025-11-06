package com.jessCSerrano.librosLibres.adapters.persistence.specification.utils;

import java.util.List;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;

public class SpecificationsUtils {

    private SpecificationsUtils() {
    }

    public static void addLikeIfPresent(String value, List<Predicate> predicates, CriteriaBuilder criteriaBuilder, Path<String> path) {
        if (value != null && !value.isBlank()) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(path), "%" + value.toLowerCase() + "%"));
        }
    }
}
