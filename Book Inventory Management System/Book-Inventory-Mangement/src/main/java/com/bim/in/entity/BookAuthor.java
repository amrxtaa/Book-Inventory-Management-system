package com.bim.in.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Bookauthor")
public class BookAuthor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookauthor_id;

    @ManyToOne
    @JoinColumn(name = "ISBN")
    @JsonIgnore
    private Book book;
    @ManyToOne
    @JoinColumn(name="author_id")
    @JsonIgnore
    private Author author;
    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }
    public Author getAuthor() {
        return author;
    }
    public void setAuthor(Author author) {
        this.author = author;
    }


    @Column
    private char primary_author;


    public char getPrimary_author() {
        return primary_author;
    }
    public void setPrimary_author(char primary_author) {
        this.primary_author = primary_author;
    }

}