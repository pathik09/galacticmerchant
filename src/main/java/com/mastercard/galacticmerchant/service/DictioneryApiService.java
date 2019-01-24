package com.mastercard.galacticmerchant.service;

import com.fasterxml.jackson.databind.JsonNode;

public interface DictioneryApiService {
	/**
	 * @param dictioneryList
	 * This method is created to hide the implementation logic of dictioneryapi from controller.
	 */
	public void dictioneryApiHelper(String dictioneryList);
	
	/**
	 * @param decimal
	 * @return
	 * This method is create to hide the implemetation logic of decimalapi from controller.
	 */
	public JsonNode decimalApiHelper(String decimal);
}
