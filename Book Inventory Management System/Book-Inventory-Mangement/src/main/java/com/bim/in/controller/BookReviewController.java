package com.bim.in.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bim.in.entity.BookReview;
import com.bim.in.repository.BookReviewRepository;


@RestController
@RequestMapping(value ="/api")

public class BookReviewController {
    public BookReviewRepository bookReviewRepository;
    @Autowired
    public BookReviewController(BookReviewRepository bookReviewRepository) {
        super();
        this.bookReviewRepository=bookReviewRepository;
    }

    @GetMapping(value = "/bookreview")
    public List<BookReview> getAllBookReview(){
        return bookReviewRepository.findAll();
    }
    @GetMapping(value ="/bookreview/{ISBN}")
    public List<BookReview> findByISBN(@PathVariable String ISBN )
    {
        return bookReviewRepository.findByISBN(ISBN);
    }
}