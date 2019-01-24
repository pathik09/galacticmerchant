package com.mastercard.galacticmerchant.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.mastercard.galacticmerchant.exception.InvalidQuantityException;
import com.mastercard.galacticmerchant.exception.RomanNumeralInvalidException;
import com.mastercard.galacticmerchant.service.DictioneryService;
import com.mastercard.jackson.model.Dictioneries;
import com.mastercard.jackson.model.Dictionery;
import com.mastercard.jackson.model.GalanticQuantity;
/**
 * @author acer
 *
 */
@Component
public class DictioneryApiHelperServiceImpl implements DictioneryApiHelperService {
	private final List<String> valdRomanNumerals;
	@Autowired
	DictioneryService dictioneryservice;
	/**
	 * THis constructor is creating the list with valid roman numerals.
	 */
	public DictioneryApiHelperServiceImpl() {
		List<String> valdRomanNumerals = new ArrayList<String>();
		valdRomanNumerals.add("I");
		valdRomanNumerals.add("V");
		valdRomanNumerals.add("X");
		valdRomanNumerals.add("L");
		valdRomanNumerals.add("C");
		valdRomanNumerals.add("D");
		valdRomanNumerals.add("M");
		this.valdRomanNumerals = Collections.unmodifiableList(valdRomanNumerals);
	}
	
	/* (non-Javadoc)
	 * @see com.mastercard.galacticmerchant.validation.DictioneryApiValidation#validateDictionery(com.mastercard.jackson.model.Dictioneries)
	 */
	@Override
	public boolean validateDictionery(Dictioneries dictioneries)
	{
		List<String> galacticCurrencyList = new ArrayList<String>();
		List<String> validRomanNumerals = new ArrayList<String>();
		List<Dictionery> dictioneryList1 = dictioneries.getDictionaries();
		dictioneryList1.forEach(dictionery -> galacticCurrencyList.add(dictionery.getRomanNumeral()));

		galacticCurrencyList.forEach(galacticCurrency -> {
			if (valdRomanNumerals.contains(galacticCurrency)) {
				validRomanNumerals.add(galacticCurrency);
			}

		});
		
		if(dictioneryList1.size() == validRomanNumerals.size())
		{

		//dictioneryList1.forEach(dictionery -> GlobalConstant.dictionaryMap.put(dictionery.getRomanNumeral(),
			//	dictionery.getRomanNumeral()));
		return true;
		}
		else
		{
			throw new RomanNumeralInvalidException("RomanNumeralInvalid Exception");
		}
	
		
	}
	
	@Override
	 public List<com.mastercard.galacticmerchant.model.Dictionery> validateforDecimalApi(GalanticQuantity galanticQuantity)
	{
		String galaticQuantity = galanticQuantity.getGalacticQuantity();
		
		List<com.mastercard.galacticmerchant.model.Dictionery> galaticQuantityList =  new ArrayList<>();;
	    String[] individualQuantity = galaticQuantity.split(" ");
	    for (String iQuantity: individualQuantity) {
	    	 List<com.mastercard.galacticmerchant.model.Dictionery> galaticQuantityList1 = dictioneryservice.findByGalacticQuantity(iQuantity);
	    	if(galaticQuantityList1.size()==0)
	    	{
	    		throw new InvalidQuantityException("Quantity does not exist.");
	    	}
	    	galaticQuantityList.add(galaticQuantityList1.get(0));
	}
		return galaticQuantityList;
	

}
}
