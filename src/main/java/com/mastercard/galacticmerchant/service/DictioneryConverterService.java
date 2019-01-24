package com.mastercard.galacticmerchant.service;

import com.mastercard.jackson.model.Dictioneries;
import com.mastercard.jackson.model.GalanticQuantity;

public interface DictioneryConverterService {
	/**
	 * @param dictioneryList
	 * @return
	 * This method will convert the json for dictionery api to the pojo class.
	 */
	public Dictioneries jsonConverterDictioneryApi(String dictioneryList);

	/**
	 * @param decimal
	 * @return
	 * THis method will convert the json for decimal api to the pojo class.
	 */
	GalanticQuantity jsonConverterDecimalApi(String decimal);

}
