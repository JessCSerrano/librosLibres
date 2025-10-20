package com.jessCSerrano.librosLibres.adapters.rest.controller.book;

import com.jessCSerrano.librosLibres.application.book.BookService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(path = "/books")
@RequiredArgsConstructor
@Tag(name = "Bookstore resource")
public class BookController {

    private final BookService bookService;


}
