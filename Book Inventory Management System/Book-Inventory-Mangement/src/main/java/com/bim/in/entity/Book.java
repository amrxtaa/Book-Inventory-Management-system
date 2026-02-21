package com.bim.in.entity;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
@Entity
@Table(name="book")
public class Book
{
    @Id
    @Column(unique=true)
    private String ISBN;
    @Column(name="title")
    private String title;

    @Column(name="Description")
    private String Description;
    @Column(name="edition")
    private String edition;

    @ManyToOne
    @JoinColumn(name="Category", referencedColumnName="catid")
    private Category category;


//    @ManyToOne
//    @JoinColumn(name="PublisherID", referencedColumnName="PublisherID")
//    private Publisher publisher;
    @OneToMany(mappedBy="book")
    @JsonIgnore
    private List<BookAuthor> bookauthors;

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String iSBN) {
        ISBN = iSBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

//    public Publisher getPublisher() {
//        return publisher;
//    }

//    public void setPublisher(Publisher publisher) {
//        this.publisher = publisher;
//    }

    public List<BookAuthor> getBookAuthors() {
        return bookauthors;
    }
    public void setBookAuthors(List<BookAuthor> bookAuthors) {
        this.bookauthors = bookAuthors;
    }
    public void setBookauthor(List<BookAuthor> bookauthor) {
        this.bookauthors = bookauthor;
    }
    public Book() {
//		super();
//		// TODO Auto-generated constructor stub
    }
    public Book(String iSBN, String title, String description, String edition, Category category,
                List<BookAuthor> bookAuthors) {
        super();
        ISBN = iSBN;
        this.title = title;
        this.Description = description;
        this.edition = edition;
        this.category = category;
//        this.publisher = publisher;
        this.bookauthors = bookAuthors;
    }
}