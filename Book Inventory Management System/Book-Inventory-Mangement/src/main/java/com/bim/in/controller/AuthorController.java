package com.bim.in.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bim.in.entity.Author;
import com.bim.in.entity.Book;
import com.bim.in.repository.AuthorRepository;
@RestController
@RequestMapping("/api")
public class AuthorController {
	private AuthorRepository authorRepository;
	@Autowired
	public  AuthorController(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}
	@GetMapping("/author")
	public List<Author> getAllAuthors()
	{
		return authorRepository.findAll();
	}

	@GetMapping(value="/author/{authorid}")
	public Optional<Author> getById(@PathVariable int authorid){
		return authorRepository.findById(authorid);
	}
	@GetMapping(value="/authors/{firstName}")
	public Author getByFirst_name(@PathVariable String firstName) {
		return authorRepository.findByFirstName(firstName);
	}
	@GetMapping(value="/authorss/{lastName}")
	public Author getByLast_name(@PathVariable String lastName) {
		return authorRepository.findByLastName(lastName);
	}
	//For update t
	@PostMapping("/author/update/{authorid}")
	public ResponseEntity<Author> updateAuthor(@PathVariable int authorid, @RequestBody Author updatedAuthor) {
		Optional<Author> authorOptional = authorRepository.findById(authorid);
		if (authorOptional.isPresent()) {
			Author author = authorOptional.get();
			// Update author details
			// Assuming you have setters in your Author class for updating details
			author.setFirst_name(updatedAuthor.getFirst_name());
			author.setLast_name(updatedAuthor.getLast_name());
			// Update other fields similarly
			// Save the updated author
			Author savedAuthor = authorRepository.save(author);
			// Return the updated author with HTTP status OK
			return ResponseEntity.ok(savedAuthor);
		} else {
			// If author with given ID not found, return HTTP status NOT FOUND
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping(value="/author/update/firstName/{authorid}")
	public ResponseEntity <Author> updateAuthorFirst_name(@PathVariable int authorid,@RequestBody String firstName)
	{
		Optional<Author> authorOptional = authorRepository.findById(authorid);
		if(authorOptional.isPresent()) {
			Author author = authorOptional.get();
			author.setFirst_name(firstName);
			Author updatedAuthor = authorRepository.save(author);
			return new ResponseEntity<>(updatedAuthor,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PutMapping(value="/author/update/lastName/{authorid}")
	public ResponseEntity <Author> updateAuthorLastName(@PathVariable int authorid,@RequestBody String lastName)
	{
		Optional<Author> authorOptional = authorRepository.findById(authorid);
		if(authorOptional.isPresent()) {
			Author author = authorOptional.get();
			author.setLast_name(lastName);
			Author updatedAuthor = authorRepository.save(author);
			return new ResponseEntity<>(updatedAuthor,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/api/author/post")
	public String createAuthor(@RequestBody Author author) {
		authorRepository.save(author);
		return "Author created successfully";
	}
}