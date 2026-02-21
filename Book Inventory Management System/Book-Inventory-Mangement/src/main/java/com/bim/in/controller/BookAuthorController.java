package com.bim.in.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bim.in.repository.BookAuthorRepository;

@RestController
@RequestMapping("/api")
public class BookAuthorController {
    private BookAuthorRepository bookAuthorRepository ;

    @Autowired
    public BookAuthorController(BookAuthorRepository bookAuthorRepository) {
        this.bookAuthorRepository=bookAuthorRepository;
    }
}