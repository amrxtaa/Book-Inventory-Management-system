package com.bim.in.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Optional;

import jakarta.persistence.*;

@Entity
@Table(name = "bookreview")
public class BookReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int book_review_id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ReviewerID")
    // @Column(name="ReviewerID")
    private Reviewer reviewer;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ISBN")
    // @Column(name = "ISBN")
    private Book book;

    public int getBookreviewid() {
        return book_review_id;
    }

    public void setBookreviewid(int bookreviewid) {
        this.book_review_id = bookreviewid;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Reviewer getReviewer() {
        return reviewer;
    }

    public void setReviewer(Reviewer reviewer) {
        this.reviewer = reviewer;
    }

    @Column(name = "rating")
    private int ratings;
    @Column(name = "Comments")
    private String comments;

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }
}