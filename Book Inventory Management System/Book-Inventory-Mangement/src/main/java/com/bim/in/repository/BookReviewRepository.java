package com.bim.in.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bim.in.entity.BookReview;

@Repository
public interface BookReviewRepository extends JpaRepository<BookReview, Integer> {
    @Query(value = "select * from BookReview where ISBN=:ISBN", nativeQuery = true)
//@Query(value = "select br from BookReview br  where br.Book.ISBN= :ISBN")
        // @Query(value = "select br.Book from BookReview br where
        // br.Physician.employeeId= :Physician")
    List<BookReview> findByISBN(String ISBN);
}