//package com.bim.in.controller;
//import com.bim.in.entity.ShoppingCart;
//import com.bim.in.repository.CategoryRepository;
//import com.bim.in.repository.ShoppingCartRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//@RestController
//@RequestMapping("/api")
//public class ShoppingCartController {
//    private ShoppingCartRepository shoppingCartRepository;
//    @Autowired
//    public ShoppingCartController(ShoppingCartRepository shoppingCartRepository) {
//        this.shoppingCartRepository = shoppingCartRepository;
//    }
//    @GetMapping("/shoppingcart/{userId}")
//    public ResponseEntity<ShoppingCart> getShoppingCart(@PathVariable Long userId) {
//        Optional<ShoppingCart> optionalCart = shoppingCartRepository.findById(userId);
//        if (optionalCart.isPresent()) {
//            return new ResponseEntity<>(optionalCart.get(), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//    @PutMapping("/api/shoppingcart/update/isbn/{userId}")
//    public ResponseEntity<ShoppingCart> updateIsbnInShoppingCart(
//            @PathVariable Long userId, @RequestBody String isbn) {
//        ShoppingCart updatedCart = shoppingCartRepository.updateIsbn(userId, isbn);
//        if (updatedCart != null) {
//            return new ResponseEntity<>(updatedCart, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//    @PostMapping("/post")
//    public ResponseEntity<String> addShoppingCart(@RequestBody ShoppingCart shoppingCart) {
//        ShoppingCart savedCart = shoppingCartRepository.addShoppingCart(shoppingCart);
//        if (savedCart != null) {
//            return ResponseEntity.status(HttpStatus.CREATED)
//                    .body("Shopping cart added successfully");
//        } else {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Failed to add shopping cart");
//        }
//    }
//}
