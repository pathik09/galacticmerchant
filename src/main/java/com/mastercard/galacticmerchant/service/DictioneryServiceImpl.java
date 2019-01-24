package com.mastercard.galacticmerchant.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.mastercard.galacticmerchant.model.Dictionery;
import com.mastercard.galaticmerchant.repository.*;

import java.util.List;
import java.util.Optional;

@Service
public class DictioneryServiceImpl implements DictioneryService {

    @Autowired
    private DictioneryRepository dictioneryRepository;

    @Override
    public Dictionery createDictionery(Dictionery dictionery) {
        return dictioneryRepository.save(dictionery);
    }

    @Override
    public Optional<Dictionery> getDictionery(Long id) {
        return dictioneryRepository.findById(id);
    }

   

  
    @Override
    public void deleteDictionery(Long id) {
        dictioneryRepository.deleteById(id);
    }

	@Override
	public Dictionery editDictionery(Dictionery dictionery) {
		return dictioneryRepository.save(dictionery);
		
	}

	@Override
	public void deleteDictionery(Dictionery dictionery) {
		dictioneryRepository.delete(dictionery);
		
	}

	@Override
	public long countDictionerys() {
		// TODO Auto-generated method stub
		return dictioneryRepository.count();
	}

	@Override
	public List<Dictionery> findByRomanNumeral(String  romanNumeral) {
		// TODO Auto-generated method stub
		return dictioneryRepository.findByRomanNumeral(romanNumeral);
	}

	@Override
	public List<Dictionery> findByGalacticQuantity(String galaticQuantity) {
		// TODO Auto-generated method stub
		return dictioneryRepository.findByGalacticCurrency(galaticQuantity);
	}

   

   
}
