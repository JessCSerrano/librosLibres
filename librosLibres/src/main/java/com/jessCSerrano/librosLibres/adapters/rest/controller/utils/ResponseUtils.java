package com.jessCSerrano.librosLibres.adapters.rest.controller.utils;

import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

/**
 * Utility class for building standard HTTP responses in the REST API
 */
public class ResponseUtils {

    private ResponseUtils() {
    }

    /**
     * Builds a ResponseEntity for a newly created resource
     *
     * @param body the resource that was created
     * @param id   the identifier of the created resource, used to build the Location URI
     * @param <T>  the type of the resource
     * @return ResponseEntity containing the created resource and Location header
     */
    public static <T> ResponseEntity<T> createUriLocation(T body, Object id) {
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
        return ResponseEntity.created(location).body(body);

    }
}
