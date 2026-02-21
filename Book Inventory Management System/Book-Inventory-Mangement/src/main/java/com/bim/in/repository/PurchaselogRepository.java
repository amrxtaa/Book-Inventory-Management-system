package com.bim.in.repository;
//package com.bim.in.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bim.in.entity.Purchaselog;

public interface PurchaselogRepository extends JpaRepository<Purchaselog, Integer> {

}