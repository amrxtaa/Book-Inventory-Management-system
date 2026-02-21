//package com.bim.in.controller;
//
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.bim.in.entity.Publisher;
//import com.bim.in.entity.State;
//import com.bim.in.entity.User;
//import com.bim.in.repository.PublisherRepository;
//import com.bim.in.repository.StateRepository;
//@RestController
//@RequestMapping(value = "/api")
//public class PublisherController {
//	private PublisherRepository publisherRepository;
//	@Autowired
//	private StateRepository stateRepository;
//
//	public PublisherController(PublisherRepository publisherRepository) {
//		super();
//		this.publisherRepository = publisherRepository;
//	}
//
//	@GetMapping(value = "/publisher")
//	public List<Publisher> getAllPublishers() {
//		return publisherRepository.findAll();
//	}
//
//	@GetMapping(value = "/publisher/{PublisherID}")
//	public Optional<Publisher> getByPublisherId(@PathVariable int PublisherID) {
//
//		return publisherRepository.findById(PublisherID);
//
//	}
//
//	@GetMapping(value = "/publisher/city/{City}")
//	public List<Publisher> getByCity(@PathVariable String City) {
//		return publisherRepository.findByCity(City);
//
//	}
//
//	@GetMapping(value = "/publisher/name/{Name}")
//	public List<Publisher> findByName(@PathVariable String Name) {
//		return publisherRepository.findByName(Name);
//	}
//
//
//	@GetMapping(value = "/publisher/statecode/{state_code}")
//	public List<Publisher> getBystate_code(@PathVariable String state_code) {
//		return publisherRepository.findBystate_code(state_code);
//	}
//
//	@PutMapping(value="/update/name/{publisherID}")
//	public ResponseEntity<Publisher> updateName(@PathVariable Integer publisherID, @RequestBody String name){
//		Publisher publisher1 = publisherRepository.findById(publisherID).orElse(null);
//
//		if(publisher1 == null){
//			return ResponseEntity.notFound().build();
//		}
//
//		publisher1.setName(name);
//
//		Publisher updatedPublisher1 = publisherRepository.save(publisher1);
//
//		return ResponseEntity.ok(updatedPublisher1);
//	}
//	@PutMapping(value="/update/city/{publisherID}")
//	public ResponseEntity<Publisher> updateCity(@PathVariable Integer publisherID, @RequestBody String city){
//		Publisher publisher1 = publisherRepository.findById(publisherID).orElse(null);
//
//		if(publisher1 == null){
//			return ResponseEntity.notFound().build();
//		}
//
//		publisher1.setCity(city);
//
//		Publisher updatedPublisher1 = publisherRepository.save(publisher1);
//
//		return ResponseEntity.ok(updatedPublisher1);
//	}
//
//	@PostMapping(value="/publisher/post")
//	private ResponseEntity<Publisher> createUser(@RequestBody Publisher publisher){
//		Publisher createPublisher=publisherRepository.save(publisher);
//		return ResponseEntity.status(HttpStatus.CREATED).body(createPublisher);
//	}
//
//}
//
//
//
//
