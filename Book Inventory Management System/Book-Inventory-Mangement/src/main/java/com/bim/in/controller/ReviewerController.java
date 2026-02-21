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
import com.bim.in.entity.Reviewer;
import com.bim.in.repository.ReviewerRepository;

@RestController
@RequestMapping(value = "/api")

public class ReviewerController {

	public ReviewerRepository reviewerRepository;

	@Autowired
	public ReviewerController(ReviewerRepository reviewerRepository) {
		super();
		this.reviewerRepository = reviewerRepository;
	}

	@GetMapping(value = "/reviewer")
	public List<Reviewer> getAllReviewer() {
		return reviewerRepository.findAll();
	}
	@GetMapping("/reviewer/{reviewerId}")
	private Optional<Reviewer> getReviewer(@PathVariable int reviewerId) {
		return reviewerRepository.findById(reviewerId);
	}

	@PostMapping(value = "/reviewer/post")
	private ResponseEntity<Reviewer> createReviewer(@RequestBody Reviewer reviewer) {
		Reviewer createReviewer = reviewerRepository.save(reviewer);
		return ResponseEntity.status(HttpStatus.CREATED).body(createReviewer);
	}

	@PutMapping(value = "/reviewer/update/name/{reviewerId}")
	public ResponseEntity<Reviewer> updateName(@PathVariable Integer reviewerId, @RequestBody String name) {
		Reviewer reviewer2 = reviewerRepository.findById(reviewerId).orElse(null);

		if (reviewer2 == null) {
			return ResponseEntity.notFound().build();
		}

		reviewer2.setName(name);
		Reviewer updated_reviewer2 = reviewerRepository.save(reviewer2);

		return ResponseEntity.ok((updated_reviewer2));
	}

	@PutMapping(value = "/reviewer/update/employedby/{reviewerId}")
	public ResponseEntity<Reviewer> updateEmployedby(@PathVariable Integer reviewerId, @RequestBody String employedby) {
		Reviewer reviewer1 = reviewerRepository.findById(reviewerId).orElse(null);

		if (reviewer1 == null) {
			return ResponseEntity.notFound().build();
		}

		reviewer1.setEmployedby(employedby);
		Reviewer updated_reviewer1 = reviewerRepository.save(reviewer1);

		return ResponseEntity.ok((updated_reviewer1));
	}
}