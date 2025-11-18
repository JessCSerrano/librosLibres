package com.jessCSerrano.librosLibres.application.author;

import com.jessCSerrano.librosLibres.common.constants.EntityNames;
import com.jessCSerrano.librosLibres.domain.exceptions.EntityNotFoundException;
import com.jessCSerrano.librosLibres.domain.model.author.Author;
import com.jessCSerrano.librosLibres.domain.model.author.Genre;
import com.jessCSerrano.librosLibres.domain.ports.out.author.AuthorRepositoryPort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class AuthorServiceTest {

    @InjectMocks
    AuthorService authorService;

    @Mock
    AuthorRepositoryPort authorRepositoryPort;

    Author authorGiven;

    @BeforeEach
    void init() {
        authorGiven = new Author(UUID.randomUUID(), "name", "lastName", "nationality", LocalDate.now(), Genre.FEMALE);
    }

    @DisplayName("Create author test")
    @Test
    void createAuthorTest() {
        //1- Given
        Mockito.when(authorRepositoryPort.saveAuthor(authorGiven)).thenReturn(authorGiven);

        //2- Act
        Author authorReturned = authorService.createAuthor(authorGiven);

        //3- Assert
        Assertions.assertEquals(authorGiven.name(), authorReturned.name());
        Assertions.assertEquals(authorGiven.lastName(), authorReturned.lastName());
    }

    @Test
    void updateExistingAuthorTest() {
        //1- Given
        Author authorGivenUpdated = new Author(authorGiven.id(), "name2", "lastName2", "nationality", LocalDate.now(), Genre.FEMALE);
        Mockito.when(authorRepositoryPort.findAuthorById(authorGiven.id())).thenReturn(Optional.ofNullable(authorGiven));
        Mockito.when(authorRepositoryPort.saveAuthor(authorGivenUpdated)).thenReturn(authorGivenUpdated);

        //2- Act
        Author authorReturned = authorService.updateAuthor(authorGiven.id(), authorGivenUpdated);

        //3- Assert
        Assertions.assertEquals(authorGivenUpdated.name(), authorReturned.name());
        Assertions.assertEquals(authorGivenUpdated.lastName(), authorReturned.lastName());
        Assertions.assertNotEquals(authorGiven.name(), authorReturned.name());
        Assertions.assertEquals(authorGiven.nationality(), authorReturned.nationality());
    }

    @Test
    void updateNonExistingAuthorTest() {
        //1- Given
        Mockito.when(authorRepositoryPort.findAuthorById(
                authorGiven.id())).thenThrow(new EntityNotFoundException(EntityNames.AUTHOR, authorGiven.id()));

        //2- Act & assert
        Assertions.assertThrows(
                EntityNotFoundException.class,
                ()-> authorService.updateAuthor(authorGiven.id(), authorGiven));
    }
}
