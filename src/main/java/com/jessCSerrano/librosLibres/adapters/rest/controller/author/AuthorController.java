package com.jessCSerrano.librosLibres.adapters.rest.controller.author;

import com.jessCSerrano.librosLibres.adapters.rest.controller.utils.ResponseUtils;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * Controller rest to manage authors.
 * Handles operations related to authors, such as creating, retrieving author data via REST endpoints.
 */
@RestController
@Slf4j
@RequestMapping(path = "/authors")
@RequiredArgsConstructor
@Tag(name = "Authors resource")
public class AuthorController {

    private final AuthorService authorService;
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
        return ResponseUtils.createUriLocation(savedAuthorDto, savedAuthorDto.id());
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

    /**
     * Updates an Author by their unique identifier with the provided new data.
     *
     * @param authorId         the unique identifier of the author to be updated
     * @param authorRequestDto the new data for the author
     * @return ResponseEntity with HTTP status 200 ok
     */
    @Operation(summary = "Update an author in the database")
    @PutMapping("/{authorId}")
    public ResponseEntity<AuthorResponseDto> updateAuthor(@PathVariable UUID authorId, @RequestBody AuthorRequestDto authorRequestDto) {
        AuthorResponseDto authorResponseDto = dtoMapper.toResponseDto(
                authorService.updateAuthor(
                        authorId,
                        dtoMapper.toDomain(authorRequestDto)
                )
        );
        return ResponseEntity.ok(authorResponseDto);
    }
}
