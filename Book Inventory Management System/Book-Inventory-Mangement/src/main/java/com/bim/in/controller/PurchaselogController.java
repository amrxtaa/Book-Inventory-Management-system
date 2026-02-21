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

import com.bim.in.entity.Inventory;
import com.bim.in.entity.PermRole;
import com.bim.in.entity.Purchaselog;
import com.bim.in.entity.User;
import com.bim.in.repository.InventoryRepository;
import com.bim.in.repository.PurchaselogRepository;
import com.bim.in.repository.UserRepository;

@RestController
@RequestMapping(value = "/api")
public class PurchaselogController {

    public PurchaselogRepository purchaselogRepository;

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public InventoryRepository inventoryRepository;

    @Autowired
    public PurchaselogController(PurchaselogRepository purchaselogRepository) {
        super();
        this.purchaselogRepository = purchaselogRepository;
    }

    @GetMapping(value = "/allpurchase")
    public List<Purchaselog> getAllPurchaselog() {
        return purchaselogRepository.findAll();

    }

    /// api/purchaselog/post - done

    @PostMapping(value = "/purchaselog/post/{userid}/{inventoryid}")
    private ResponseEntity<Purchaselog> createUser(@RequestBody Purchaselog purchaselog,
                                                   @PathVariable("userid") int userid, @PathVariable("inventoryid") int inventoryid) {

        User user = userRepository.findByuserid(userid);
        Inventory inventory = inventoryRepository.findByinventoryid(inventoryid);
        if (user == null || inventory == null) {
            return ResponseEntity.badRequest().body(null);
        }
        purchaselog.setUserID(user);
        purchaselog.setInventoryID(inventory);
        Purchaselog savedPurchaselog = purchaselogRepository.save(purchaselog);
        return ResponseEntity.ok(savedPurchaselog);
    }

    /// api/purchaselog/{userId} - done

    @GetMapping(value = "/purchaselog/{id}")
    public Optional<Purchaselog> getPurchaselogByUserID(@PathVariable int id) {
        return purchaselogRepository.findById(id);
    }

    // /api/purchaselog/update/inventoryid/{userId} - id

    @PutMapping(value = "/purchaselog/update/inventory/{id}/{InventoryID}")
    public ResponseEntity<Purchaselog> updatePhoneNumber(@PathVariable Integer id, @PathVariable int InventoryID) {
        Optional<Purchaselog> purchaselog = purchaselogRepository.findById(id);
        if (purchaselog.isPresent()) {
            Purchaselog purchaselog2 = purchaselog.get();
            Inventory inventory = new Inventory();
            inventory.setInventoryID(InventoryID);
            purchaselog2.setInventoryID(inventory);
            purchaselogRepository.save(purchaselog2);
            return ResponseEntity.ok(purchaselog2);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}