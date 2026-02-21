package com.bim.in.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bim.in.entity.Author;
import com.bim.in.entity.Book;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer>{
//	@Query("SELECT b FROM BookAuthor ab JOIN ab.book b WHERE ab.author.id = :authorId")
//    List<Book> findBooksByAuthorId(@Param("authorId") Integer authorId);

    Author findByFirstName(String string);

    Author findByLastName(String lastName);
}