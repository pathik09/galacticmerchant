package com.mastercard.galacticmerchant.service;

import java.util.List;

import com.mastercard.galacticmerchant.model.Dictionery;
import com.mastercard.jackson.model.Dictioneries;
import com.mastercard.jackson.model.GalanticQuantity;

/**
 * @author pathik
 * THis interface is for a concrete class which does the necessary validations related to dictionery api.
 *
 */
public interface DictioneryApiHelperService {

	/**
	 * @param dictioneries
	 * @return
	 * This method is created as a helper to DictioneryApiController class, this method
	 * is taking care of the validations it requires before adding it to the database.
	 * Like the list should only contain the valid roman letters. so this requirement is taken
	 * care here.
	 */
	boolean validateDictionery(Dictioneries dictioneries);
	
	/**
	 * @param galanticQuantity
	 * @return
	 * This method is used to help with validations necessary fir DecimalApi method.
	 */
	public List<Dictionery> validateforDecimalApi(GalanticQuantity galanticQuantity);
	

}
