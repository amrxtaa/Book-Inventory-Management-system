package com.bim.in.repository;
import com.bim.in.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
@Repository
public interface BookRepository extends JpaRepository<Book,String>{
// @Query("SELECT b FROM Book b WHERE b.publisher.PublisherID = :publisherID")
// List<Book> findByPublisherPublisherID(@Param("publisherID")int PublisherID);
 @Query(value = "SELECT * FROM Book WHERE Category IN( Select catid from category where cat_description=?1)", nativeQuery = true)
 List<Book> findByCategorycat_description(String cat_description);
 Optional<Book> findByISBN(String ISBN);
 List<Book> findByTitle(String title);
 List<Book> findByBookauthors_Author_Authorid(Integer authorid);
}