package com.bim.in.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.*;

@Entity
public class Reviewer {
	@Id
	@Column(name = "ReviewerID")
	private int reviewerId;
	@Column(name = "Name")
	private String name;
	@Column
	private String employedby;

	public int getReviewerId() {
		return reviewerId;
	}

	public void setReviewerId(int reviewerId) {
		this.reviewerId = reviewerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmployedby() {
		return employedby;
	}

	public void setEmployedby(String employedby) {
		this.employedby = employedby;
	}
	// @OneToMany(cascade = CascadeType.ALL,mappedBy = "reviewer")
	// private List<BookReview> bookReviews;
}