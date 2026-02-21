package com.bim.in.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bim.in.pojo.BookPojo;
@Service
public class BookPojoService {
    @Autowired
    private RestTemplate restTemplate;
    public List<BookPojo> getAllBooks() {
        ResponseEntity<List<BookPojo>> response = restTemplate.exchange(
                "http://localhost:9999/api/books",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<BookPojo>>() {});
        return response.getBody();
    }
    public BookPojo getByISBN(String ISBN) {
        String url = "http://localhost:9999/api/book/" + ISBN;
        return restTemplate.getForObject(url, BookPojo.class);
    }
    public BookPojo saveBook(BookPojo bookPojo) {
        ResponseEntity<BookPojo> response = restTemplate.postForEntity(
                "http://localhost:9999/api/book/post",
                bookPojo,
                BookPojo.class);
        return response.getBody();
    }
    public BookPojo findByISBN(String ISBN) {
        ResponseEntity<BookPojo> response = restTemplate.exchange(
                "http://localhost:9999/api/book/"+ISBN,
                HttpMethod.GET,
                null,
                BookPojo.class);
        return response.getBody();
    }
    public void updateBook(BookPojo bookPojo) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        HttpEntity<BookPojo> requestEntity = new HttpEntity<>(bookPojo, headers);
        ResponseEntity<Void> response = restTemplate.exchange(
                "http://localhost:9999/api/books/update",
                HttpMethod.PUT,
                requestEntity,
                Void.class);
        // Check the response status if needed
        if (response.getStatusCode().is2xxSuccessful()) {
            System.out.println("Book updated successfully");
        } else {
            System.out.println("Failed to update Book");
        }
    }
}