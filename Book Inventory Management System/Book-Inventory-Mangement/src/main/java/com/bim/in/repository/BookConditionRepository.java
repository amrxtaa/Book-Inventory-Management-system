package com.bim.in.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bim.in.entity.BookCondition;

@Repository
public interface BookConditionRepository extends JpaRepository<BookCondition, Integer> {

    BookCondition findByranks(int ranks);

}