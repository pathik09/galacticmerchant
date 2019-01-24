package com.mastercard.galacticmerchant.controller;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.mastercard.galacticmerchant.service.DictioneryApiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping("galacticmerchant")
public class DictionaryApiController {

	@Autowired
	DictioneryApiService dictioneryApiService;

	/**
	 * @param dictioneryList
	 * @return
	 * @return
	 * @return
	 * @return This api takes the input from the user and saves it into the h2
	 *         database, if request is valid, and returns 204 response to the user.
	 *         If the request is not valid, means if the json is invalid or
	 *         romannumeral is invalid then it sends 400 response to the user.
	 */
	@RequestMapping(value = "/dictionary", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity dictionaryApi(@RequestBody String dictioneryList) {
		dictioneryApiService.dictioneryApiHelper(dictioneryList);
		return new ResponseEntity(HttpStatus.NO_CONTENT);

	}

	/**
	 * @param galanticQquantity
	 * @throws Exception
	 * This api takes the input from the user and retrieves the equivelent decimal value 
	 * of the galactic quantity provided, first it checks whether the provided galactic
	 * quantity is in the h2 database or not, if it is then, it will first convert it
	 * into the roman digits as stored in the h2 database and then converts that into 
	 * the decimal using romancalculatorservice.  
	 */
	@RequestMapping(value = "/decimal", method = RequestMethod.POST, consumes = "application/json")
	public JsonNode decimal(@RequestBody String decimal) {
		JsonNode jsonNode = dictioneryApiService.decimalApiHelper(decimal);

		return jsonNode;

	}

}