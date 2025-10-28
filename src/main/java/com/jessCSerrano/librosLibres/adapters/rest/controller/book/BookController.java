package com.jessCSerrano.librosLibres.adapters.rest.controller.book;

import com.jessCSerrano.librosLibres.adapters.rest.controller.utils.ResponseUtils;
import com.jessCSerrano.librosLibres.adapters.rest.dto.book.BookRequestDto;
import com.jessCSerrano.librosLibres.adapters.rest.dto.book.BookResponseDto;
import com.jessCSerrano.librosLibres.adapters.rest.mapper.BookDtoMapper;
import com.jessCSerrano.librosLibres.application.book.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

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

    /**
     * Creates a new book with the provided book information
     *
     * @param bookRequestDto the data of the new book
     * @return ResponseEntity with status 201 Created and Location header pointing to the newly created resource.
     */
    @Operation(summary = "Create a new book and saves it in the database")
    @PostMapping
    public ResponseEntity<BookResponseDto> createBook(@RequestBody BookRequestDto bookRequestDto) {
        BookResponseDto savedBookDto = dtoMapper.toResponseDto(
                bookService.createBook(
                        dtoMapper.toDomain(bookRequestDto)
                )
        );
        return ResponseUtils.createUriLocation(savedBookDto, savedBookDto.getId());
    }

    /**
     * Deletes a given book from the database.
     *
     * @param bookId the unique identifier of the book to delete
     * @return 204 No Content if the book was deleted successfully
     */
    @Operation(summary = "Delete a book from the database")
    @DeleteMapping("/{bookId}")
    @ApiResponse(responseCode = "204", description = "Book deleted successfully")
    public ResponseEntity<Void> deleteBook(@PathVariable UUID bookId) {
        bookService.deleteBook(bookId);
        return ResponseEntity.noContent().build();
    }

}
