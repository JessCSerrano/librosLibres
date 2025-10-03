package com.jessCSerrano.librosLibres.adapters.rest.controller.author;

import com.jessCSerrano.librosLibres.adapters.persistence.mapper.AuthorEntityMapper;
import com.jessCSerrano.librosLibres.adapters.rest.dto.author.AuthorRequestDto;
import com.jessCSerrano.librosLibres.adapters.rest.dto.author.AuthorResponseDto;
import com.jessCSerrano.librosLibres.adapters.rest.mapper.AuthorDtoMapper;
import com.jessCSerrano.librosLibres.application.author.AuthorService;
import com.jessCSerrano.librosLibres.domain.model.author.Author;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

/**
 * Controller rest to manage authors.
 * Allows you to create a new author using REST endpoint.
 */
@RestController
@Slf4j
@RequestMapping(path = "/authors")
@RequiredArgsConstructor
@Tag(name = "Authors resource")
public class AuthorController {

    private final AuthorService authorService;
    private final AuthorEntityMapper entityMapper;
    private final AuthorDtoMapper dtoMapper;

    /**
     * Creates a new author based on authorDto received in the request.
     * @param authorRequestDto with his details.
     * @return AuthorDto created.
     */
    @Operation(summary = "creates a new author and saves it in the database")
    @PostMapping
    public ResponseEntity<AuthorResponseDto> createAuthor(@RequestBody AuthorRequestDto authorRequestDto) {
        Author author = dtoMapper.toDomain(authorRequestDto);
        Author authorSaved =  authorService.createAuthor(author);
        AuthorResponseDto savedDto = dtoMapper.toResponseDto(authorSaved);
        URI location = URI.create("/authors/" + savedDto.getId());
        return ResponseEntity.created(location).body(savedDto);
    }
}
