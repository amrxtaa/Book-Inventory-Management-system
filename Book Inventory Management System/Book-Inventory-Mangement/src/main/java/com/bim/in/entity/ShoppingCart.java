//package com.bim.in.entity;
//
//
//import jakarta.persistence.*;
//
//import java.util.List;
//
//
//
//import jakarta.persistence.*;
//
//import java.util.List;
//
//
//@Entity
//
//@Table(name = "shoppingcart")
//public class ShoppingCart {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int sid;
//    @OneToOne
//    @JoinColumn(name = "UserID")
//    private User user;
//    @OneToMany
//    @JoinColumn(name = "ISBN")
//    private List<Book> books;
//
//    public int getSid() {
//        return sid;
//    }
//
//    public void setSid(int sid) {
//        this.sid = sid;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public List<Book> getBooks() {
//        return books;
//    }
//
//    public void setBooks(List<Book> books) {
//        this.books = books;
//    }
//}