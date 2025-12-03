package com.jessCSerrano.librosLibres.adapters.rest.controller.author;

import com.jessCSerrano.librosLibres.adapters.rest.dto.author.AuthorRequestDto;
import com.jessCSerrano.librosLibres.adapters.rest.dto.author.AuthorResponseDto;
import com.jessCSerrano.librosLibres.adapters.rest.mapper.AuthorDtoMapper;
import com.jessCSerrano.librosLibres.application.author.AuthorService;
import com.jessCSerrano.librosLibres.domain.model.author.Author;
import com.jessCSerrano.librosLibres.domain.model.author.Genre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class AuthorControllerTest {

    @InjectMocks
    private AuthorController authorController;

    @Mock
    private AuthorService authorService;

    @Mock
    private AuthorDtoMapper dtoMapper;

    private Author authorGiven;

    private AuthorResponseDto authorResponseDtoGiven;

    @BeforeEach
    void init() {
        authorGiven = new Author(UUID.randomUUID(), "firstName", "lastName", "nationality", LocalDate.now(), Genre.FEMALE);
        authorResponseDtoGiven = new AuthorResponseDto(authorGiven.id(), "firstName", "lastName", "nationality", LocalDate.now(), Genre.FEMALE);
    }

    @Test
    void createAuthorTest() {
        //1- Given
        AuthorRequestDto authorRequestDtoGiven = new AuthorRequestDto("firstName", "lastName", "nationality", LocalDate.now(), Genre.FEMALE);

        Mockito.when(dtoMapper.toDomain(authorRequestDtoGiven)).thenReturn(authorGiven);
        Mockito.when(dtoMapper.toResponseDto(authorGiven)).thenReturn(authorResponseDtoGiven);
        Mockito.when(authorService.createAuthor(authorGiven)).thenReturn(authorGiven);

        //2- Act
        ResponseEntity<AuthorResponseDto> authorReturned = authorController.createAuthor(authorRequestDtoGiven);

        //3- Assert
        Assertions.assertEquals(authorReturned.getBody().firstName(), authorGiven.firstName());
    }

    @Test
    void getAuthorsTest() {
        //1- Given
        List<Author> listAuthorsGiven = List.of(authorGiven);
        List<AuthorResponseDto> listAuthorsResponseDtoGiven = List.of(authorResponseDtoGiven);

        Mockito.when(authorService.getAuthors()).thenReturn(listAuthorsGiven);
        Mockito.when(dtoMapper.toResponseDtoList(listAuthorsGiven)).thenReturn(listAuthorsResponseDtoGiven);

        //2- Act
        ResponseEntity<List<AuthorResponseDto>> listAuthorResponseDtoReturned = authorController.getAuthors();

        //3- Assert
        Assertions.assertEquals(listAuthorResponseDtoReturned.getBody(), listAuthorsResponseDtoGiven);
    }


    @Test
    void updateAuthorTest() {
        //1- Given
        AuthorRequestDto authorRequestDtoGiven = new AuthorRequestDto("firstName", "lastName", "nationality2", LocalDate.now(), Genre.FEMALE);
        AuthorResponseDto authorResponseDtoGiven = new AuthorResponseDto(authorGiven.id(), "firstName", "lastName", "nationality2", LocalDate.now(), Genre.FEMALE);


        Mockito.when(dtoMapper.toResponseDto(authorGiven)).thenReturn(authorResponseDtoGiven);
        Mockito.when(dtoMapper.toDomain(authorRequestDtoGiven)).thenReturn(authorGiven);
        Mockito.when(authorService.updateAuthor(authorGiven.id(), authorGiven)).thenReturn(authorGiven);

        //2- Act
        ResponseEntity<AuthorResponseDto> authorResponseDtoReturned = authorController.updateAuthor(authorGiven.id(), authorRequestDtoGiven);

        //3- Assert
        Assertions.assertEquals(authorResponseDtoReturned.getBody().firstName(), authorGiven.firstName());
        Assertions.assertNotEquals(authorResponseDtoReturned.getBody().nationality(), authorGiven.nationality());
    }

    @Test
    void deleteAuthorByIdTest() {
        //1- Given
        Mockito.doNothing().when(authorService).deleteAuthorById(authorGiven.id());

        //2- Act
        ResponseEntity<Void> response = authorController.deleteAuthorById(authorGiven.id());

        //Assert
        Mockito.verify(authorService).deleteAuthorById(authorGiven.id());
        Assertions.assertNull(response.getBody());
    }
}
