//package com.bim.in.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.bim.in.entity.State;
//import com.bim.in.repository.StateRepository;
//import com.bim.in.repository.UserRepository;
//
//@RestController
//@RequestMapping(value = "/api")
//public class StateController {
//
//	private StateRepository stateRepository;
//
//	@Autowired
//	public StateController(StateRepository stateRepository) {
//		super();
//		this.stateRepository = stateRepository;
//	}
//	@GetMapping(value = "/states")
//	public List<State> getAllStates() {
//        return stateRepository.findAll();
//	}
//}
