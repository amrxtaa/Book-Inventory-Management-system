package com.bim.in.controller;


import java.util.ArrayList;
import java.util.List;

import com.bim.in.service.BookPojoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.bim.in.pojo.BookPojo;

@Controller
public class BookPojoController {
    @Autowired
    private BookPojoService bookService;
    @GetMapping("/Books")
    public String showBooks(Model model) {
        List<BookPojo> books = bookService.getAllBooks();
        if (books == null) {
            books= new ArrayList<>();
        }
        model.addAttribute("books", books);
        return "book"; // Assuming you have a Thymeleaf template named "task1.html"
    }

     
    @GetMapping("/insert")
    public String showInsertedBooks(Model model) {
        return "addBook"; // This will return index.html Thymeleaf template
    }
    @PostMapping("/add")
    public String submitBook(BookPojo bookPojo, RedirectAttributes redirectAttributes) {
        // Save the submitted task to the database
        bookService.saveBook(bookPojo);
        // Redirect to the Tasks page after form submission
        redirectAttributes.addFlashAttribute("successMessage", "Book submitted successfully.");
        return "redirect:/Books";
    }
    @GetMapping("/update/{ISBN}")
    public String showUpdatedBook(@PathVariable String ISBN, Model model) {
        BookPojo bookPojo = bookService.findByISBN(ISBN);
        if (bookPojo == null) {
            bookPojo= new BookPojo();
        }
        model.addAttribute("bookPojo", bookPojo);
        return "updatebook"; // Assuming you have a Thymeleaf template named "task1.html"
    }
    @PostMapping("/update")
    public String updateBook(BookPojo bookPojo, RedirectAttributes redirectAttributes) {
        // Logic to update the task
        bookService.updateBook(bookPojo);
        // Redirect to the Tasks page after form submission
        redirectAttributes.addFlashAttribute("successMessage", "Task submitted successfully.");
        return "redirect:/Books";
    }
}