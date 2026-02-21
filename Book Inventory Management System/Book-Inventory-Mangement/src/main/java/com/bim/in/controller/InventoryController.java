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
import org.springframework.web.bind.annotation.RestController;

import com.bim.in.entity.Inventory;
import com.bim.in.entity.PermRole;
import com.bim.in.entity.User;
import com.bim.in.repository.InventoryRepository;


@RestController
@RequestMapping(value="/api")
public class InventoryController {
	public InventoryRepository inventoryRepository;
	@Autowired
	public InventoryController(InventoryRepository inventoryRepository) {
		super();
		this.inventoryRepository = inventoryRepository;
	}
	@GetMapping(value = "/inventory")
	public List<Inventory> getAllInventory(){
		return inventoryRepository.findAll();
	}
	//"/api/inventory/{inventoryId} " -done
	@GetMapping(value="/inventory/{InventoryID}")
	public Optional<Inventory> getById(@PathVariable int InventoryID){
		return inventoryRepository.findById(InventoryID);
	}
	//"api/inventory/post"
	@PostMapping(value="/inventory/post")
	private ResponseEntity<Inventory> createInventory(@RequestBody Inventory inventory){
		Inventory createInventory=inventoryRepository.save(inventory);
		return ResponseEntity.status(HttpStatus.CREATED).body(createInventory);
	}
	//"/api/inventory/update/purchased/{inventoryId}"
	@PutMapping(value="/inventory/update/purchased/{inventoryId}")
	public ResponseEntity<Inventory> updatePhoneNumber(@PathVariable Integer InventoryID, @RequestBody Integer purchased){
		Inventory inventory1 = inventoryRepository.findById(InventoryID).orElse(null);
		if(inventory1 == null){
			return ResponseEntity.notFound().build();
		}
		inventory1.setPurchased(purchased);
		Inventory updatedinventory1 = inventoryRepository.save(inventory1);
		return ResponseEntity.ok((updatedinventory1));
	}

}