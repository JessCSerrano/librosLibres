package com.jessCSerrano.librosLibres.adapters.rest.controller.author;

import com.jessCSerrano.librosLibres.adapters.persistence.mapper.AuthorEntityMapper;
import com.jessCSerrano.librosLibres.adapters.rest.dto.author.AuthorRequestDto;
import com.jessCSerrano.librosLibres.adapters.rest.dto.author.AuthorResponseDto;
import com.jessCSerrano.librosLibres.adapters.rest.mapper.AuthorDtoMapper;
import com.jessCSerrano.librosLibres.application.author.AuthorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

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
     *
     * @param authorRequestDto with his details.
     * @return AuthorDto created and his location.
     */
    @Operation(summary = "creates a new author and saves it in the database")
    @PostMapping
    public ResponseEntity<AuthorResponseDto> createAuthor(@RequestBody AuthorRequestDto authorRequestDto) {
        AuthorResponseDto savedAuthorDto = dtoMapper.toResponseDto(
                authorService.createAuthor(
                        dtoMapper.toDomain(authorRequestDto)
                )
        );
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedAuthorDto.id())
                .toUri();
        return ResponseEntity.created(location).body(savedAuthorDto);
    }

    /**
     * Returns all authors stored in the database.
     *
     * @return a list of AuthorResponseDto.
     */
    @Operation(summary = "Return all authors stored in the database")
    @GetMapping
    public ResponseEntity<List<AuthorResponseDto>> getAuthors() {
        return ResponseEntity.ok(
                dtoMapper.toResponseDtoList(
                        authorService.getAuthors()
                )
        );
    }
}
