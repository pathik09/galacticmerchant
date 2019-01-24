package com.mastercard.galaticmerchant.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.mastercard.galacticmerchant.model.Dictionery;

@Repository
public interface DictioneryRepository extends JpaRepository<Dictionery, Long> {
List<Dictionery> findByRomanNumeral(String romanNumeral);
List<Dictionery> findByGalacticCurrency(String galacticCurrency);
	
}