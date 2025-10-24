package com.jessCSerrano.librosLibres.adapters.rest.controller.book;

import com.jessCSerrano.librosLibres.adapters.rest.controller.utils.ResponseUtils;
import com.jessCSerrano.librosLibres.adapters.rest.dto.book.BookRequestDto;
import com.jessCSerrano.librosLibres.adapters.rest.dto.book.BookResponseDto;
import com.jessCSerrano.librosLibres.adapters.rest.mapper.BookDtoMapper;
import com.jessCSerrano.librosLibres.application.book.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller rest to manage books.
 * Handles operations related to books
 */
@RestController
@Slf4j
@RequestMapping(path = "/books")
@RequiredArgsConstructor
@Tag(name = "Bookstore resource")
public class BookController {

    private final BookService bookService;
    private final BookDtoMapper dtoMapper;

    @Operation(summary = "creates a new book and saves it in the database")
    @PostMapping
    public ResponseEntity<BookResponseDto> createBook(@RequestBody BookRequestDto bookRequestDto) {
        BookResponseDto savedBookDto = dtoMapper.toResponseDto(
                bookService.createBook(
                        dtoMapper.toDomain(bookRequestDto)
                )
        );
        return ResponseUtils.createUriLocation(savedBookDto, savedBookDto.getId());
    }

}
