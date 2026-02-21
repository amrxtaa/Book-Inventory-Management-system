package com.bim.in.controller;
import com.bim.in.entity.Book;
import com.bim.in.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api")
public class BookController
{
    private final BookRepository bookRepository;
    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository=bookRepository;
    }
    @GetMapping("/books")
    public List<Book> findAllBooks()
    {
        return bookRepository.findAll();
    }
    @GetMapping(value= "/book/{ISBN}")
    public Optional<Book> findByISBN(@PathVariable String ISBN)
    {
        return bookRepository.findByISBN(ISBN);
    }
    @GetMapping("/book/title/{title}")
    public List<Book> findByTitle(@PathVariable String title) {
        return bookRepository.findByTitle(title);
    }
    @GetMapping("/book/category/{cat_description}")
    public List<Book> findByCategory(@PathVariable String cat_description)
    {
        return bookRepository.findByCategorycat_description(cat_description);
    }
//    @GetMapping("/book/publisher/{publisherID}")
//    public List<Book> getByPublisherID(@PathVariable int publisherID) {
//        return bookRepository.findByPublisherPublisherID(publisherID);
//    }
    @GetMapping(value="/author/books/{authorid}")
    public List<Book> getBooksByAuthorId(@PathVariable Integer authorid){
        return bookRepository.findByBookauthors_Author_Authorid(authorid);
    }
    @PutMapping("/api/book/update/title/{isbn}")
    public String updateBookTitle(@PathVariable String isbn, @RequestBody Book request) {
        Book book = bookRepository.findById(isbn).orElse(null);
        if (book == null) {
            return "Book not found";
        }
        book.setTitle(request.getTitle());
        bookRepository.save(book);
        return "Book title updated successfully";
    }
    @PutMapping("/book/{isbn}")
    public String updateBook(@PathVariable String isbn, @RequestBody Book updatedBook) {
        Book book = bookRepository.findById(isbn).orElse(null);
        if (book == null) {
            return "Book with ISBN " + isbn + " not found";
        }
        book.setTitle(updatedBook.getTitle());
        book.setDescription(updatedBook.getDescription());


        bookRepository.save(book);
        return "Book with ISBN " + isbn + " updated successfully";
    }
@PostMapping("/book/post")
public String createBook(@RequestBody Book book) {
    bookRepository.save(book);
    return "Book created successfully";
}
}