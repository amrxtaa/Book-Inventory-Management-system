//package com.bim.in.controller;
//
//import java.util.List;
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
//import com.bim.in.entity.Inventory;
//import com.bim.in.entity.PermRole;
//import com.bim.in.repository.PermRoleRepository;
//
//@RestController
//@RequestMapping(value = "/api")
//public class PermRoleController {
//
//	public PermRoleRepository permroleRepository;
//
//	@Autowired
//	public PermRoleController(PermRoleRepository permroleRepository) {
//		super();
//		this.permroleRepository = permroleRepository;
//	}
//
//	@GetMapping(value = "/role")
//	public List<PermRole> getAllroles() {
//		return permroleRepository.findAll();
//	}
//
//	// "api/permrole/{rolenumber}" - done
//
//	@GetMapping(value = "/permrole/{role_number}")
//	public Optional<PermRole> getById(@PathVariable int role_number) {
//		return permroleRepository.findById(role_number);
//	}
//
//	// "api/permrole/post" - done
//
//	@PostMapping(value = "/permrole/post")
//	private ResponseEntity<PermRole> createInventory(@RequestBody PermRole permrole) {
//		PermRole createPermrole = permroleRepository.save(permrole);
//		return ResponseEntity.status(HttpStatus.CREATED).body(createPermrole);
//	}
//
//	// "api/permrole/update/permeole/{rolenumber}" -done
//
//	@PutMapping(value = "/permrole/update/permrole/{roleNumber}")
//	public ResponseEntity<PermRole> updatePermrole(@PathVariable Integer roleNumber, @RequestBody String permRole) {
//		PermRole permrole1 = permroleRepository.findById(roleNumber).orElse(null);
//		if (permrole1 == null) {
//			return ResponseEntity.notFound().build();
//		}
//		permrole1.setPermRole(permRole);
//		PermRole updatedpermrole = permroleRepository.save(permrole1);
//		return ResponseEntity.ok(updatedpermrole);
//	}
//}