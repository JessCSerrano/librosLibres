package com.jessCSerrano.librosLibres.adapters.persistence.entity.author;

import com.jessCSerrano.librosLibres.domain.model.author.Genre;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Represents an author of one or more books in the bookstore system.
 */
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "authors")
public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @EqualsAndHashCode.Include
    private UUID id;
    @ToString.Include
    private String name;
    @ToString.Include
    private String lastName;
    @ToString.Include
    private String nationality;
    @ToString.Include
    private LocalDate dateOfBirth;
    @ToString.Include
    @Enumerated(value = EnumType.STRING)
    private Genre genre;

}
