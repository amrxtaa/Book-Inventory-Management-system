package com.bim.in.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.bim.in.entity.BookAuthor;
@Repository
public interface BookAuthorRepository extends JpaRepository<BookAuthor, Integer> {
}


