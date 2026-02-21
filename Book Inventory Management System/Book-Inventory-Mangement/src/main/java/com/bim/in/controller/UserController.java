package com.bim.in.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bim.in.entity.BookCondition;
import com.bim.in.entity.PermRole;
import com.bim.in.entity.User;
import com.bim.in.repository.PermRoleRepository;
import com.bim.in.repository.UserRepository;

@RestController
@RequestMapping(value="/api")
public class UserController {

	public UserRepository userRepository;

	@Autowired
	public UserController(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Autowired
	public PermRoleRepository permRoleRepository;



	@GetMapping(value="/allusers")
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}

	@GetMapping(value = "/users/{firstName}")
	public List<User> getOneUser(@PathVariable String firstName){
		return userRepository.findByFirstName(firstName);
	}

	//"/api/user/{userId}" - done

	@GetMapping(value = "/user/{userid}")
	public Optional<User> getById(@PathVariable int userid){

		return userRepository.findById(userid);
	}



	//"/api/user/post" - done

	@PostMapping(value="/user/post/{roleNumber}")
	private ResponseEntity<User> createUser(@RequestBody User user,@PathVariable("roleNumber") int roleNumber){

		PermRole permRole = permRoleRepository.findByRoleNumber(roleNumber);
		if (permRole == null) {
			return ResponseEntity.badRequest().body(null);
		}
		user.setPremrole(permRole);
		User savedUser = userRepository.save(user);
		return ResponseEntity.ok(savedUser);
	}


	//"/api/user/update/phonenumber/{userId} " - done

	@PutMapping(value="/user/update/phoneNumber/{userid}")
	public ResponseEntity<User> updatePhoneNumber(@PathVariable Integer userid, @RequestBody String phoneNumber){
		User user1 = userRepository.findById(userid).orElse(null);
		if(user1 == null){
			return ResponseEntity.notFound().build();
		}
		user1.setPhoneNumber(phoneNumber);
		User updateduser1 = userRepository.save(user1);
		return ResponseEntity.ok((updateduser1));
	}

	//"api/user/update/lastname/{userId}" - done

	@PutMapping(value="/user/update/lastName/{userid}")
	public ResponseEntity<User> updateLastName(@PathVariable Integer userid, @RequestBody String lastName){
		User user1 = userRepository.findById(userid).orElse(null);
		if(user1==null) {
			return ResponseEntity.notFound().build();
		}
		user1.setLastName(lastName);
		User updateduser1 = userRepository.save(user1);
		return ResponseEntity.ok(updateduser1);
	}


	//"/api/user/update/firstname/{userId}" - done

	@PutMapping(value="user/update/firstname/{userid}")
	public ResponseEntity<User> updateFirstName(@PathVariable Integer userid, @RequestBody String firstName){
		User user1 = userRepository.findById(userid).orElse(null);
		if(user1==null) {
			return ResponseEntity.notFound().build();
		}
		user1.setFirstName(firstName);
		User updateduser1=userRepository.save(user1);
		return ResponseEntity.ok(updateduser1);
	}


}