package com.mastercard.galaticmerchant.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mastercard.galacticmerchant.model.ProductConfig;

@Repository
public interface ProductRepository extends JpaRepository<ProductConfig, Long> {
List<ProductConfig> findByProductName(String productName);
	
}
