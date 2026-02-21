package com.bim.in.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bim.in.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	List<User> findByFirstName(String string);

	User findByuserid(int userid);

}
