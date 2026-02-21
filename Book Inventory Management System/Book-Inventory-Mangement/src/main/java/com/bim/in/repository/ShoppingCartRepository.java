//package com.bim.in.repository;
//
//import com.bim.in.entity.ShoppingCart;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.Optional;
//
//@Repository
//public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
//    ShoppingCart findByUserId(Long userId);
//    ShoppingCart updateIsbn(Long userId, String isbn);
//    ShoppingCart addShoppingCart(ShoppingCart shoppingCart);
//}