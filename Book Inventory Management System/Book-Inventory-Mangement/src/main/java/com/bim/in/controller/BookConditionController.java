
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
import com.bim.in.entity.BookCondition;
import com.bim.in.entity.Reviewer;
import com.bim.in.repository.BookConditionRepository;

@RestController
@RequestMapping(value = "/api")

public class BookConditionController {
	public BookConditionRepository bookConditionRepository;

	@Autowired
	public BookConditionController(BookConditionRepository bookConditionRepository) {
		super();
		this.bookConditionRepository = bookConditionRepository;
	}

	@GetMapping(value = "/bookcondition")
	public List<BookCondition> getAllBookCondition() {
		return bookConditionRepository.findAll();
	}

	@GetMapping(value = "/bookcondition/{ranks}")
	private Optional<BookCondition> getBookCondition(@PathVariable int ranks) {
		return bookConditionRepository.findById(ranks);
	}

	@PostMapping(value = "/bookcondition/post")
	private ResponseEntity<BookCondition> createBookCondition(@RequestBody BookCondition bookCondition) {
		BookCondition createBookCondition = bookConditionRepository.save(bookCondition);
		return ResponseEntity.status(HttpStatus.CREATED).body(createBookCondition);
	}

	@PutMapping(value = "/bookcondition/update/fullDescription/{ranks}")
	public ResponseEntity<BookCondition> updateFull_description(@PathVariable Integer ranks,
																@RequestBody String full_description) {
		BookCondition book_condition = bookConditionRepository.findById(ranks).orElse(null);

		if (book_condition == null) {
			return ResponseEntity.notFound().build();
		}

		book_condition.setFull_description(full_description);
		BookCondition updated_condition1 = bookConditionRepository.save(book_condition);

		return ResponseEntity.ok((updated_condition1));
	}

	@PutMapping(value = "/bookcondition/update/description/{ranks}")
	public ResponseEntity<BookCondition> updateDescription(@PathVariable Integer ranks,
														   @RequestBody String description) {
		BookCondition book_condition1 = bookConditionRepository.findById(ranks).orElse(null);

		if (book_condition1 == null) {
			return ResponseEntity.notFound().build();
		}

		book_condition1.setDescription(description);
		BookCondition updated_condition2 = bookConditionRepository.save(book_condition1);

		return ResponseEntity.ok((updated_condition2));
	}

	@PutMapping(value = "/bookcondition/update/price/{ranks}")
	public ResponseEntity<BookCondition> updatePrice(@PathVariable Integer ranks, @RequestBody Double price) {
		BookCondition book_condition2 = bookConditionRepository.findById(ranks).orElse(null);

		if (book_condition2 == null) {
			return ResponseEntity.notFound().build();
		}

		book_condition2.setPrice(price);
		BookCondition updated_condition3 = bookConditionRepository.save(book_condition2);

		return ResponseEntity.ok((updated_condition3));
	}

}
