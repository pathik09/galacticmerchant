package com.mastercard.galacticmerchant.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mastercard.galacticmerchant.exception.InvalidJsonException;
import com.mastercard.galacticmerchant.exception.InvalidQuantityException;
import com.mastercard.galacticmerchant.exception.UnknownException;
import com.mastercard.jackson.model.Dictioneries;
import com.mastercard.jackson.model.Dictionery;
import com.mastercard.jackson.model.GalanticQuantity;

@Service
public class DictioneryApiServiceImpl implements DictioneryApiService {
	@Autowired
	DictioneryApiHelperService dictionaryapivalidation;
	@Autowired
	DictioneryService dictioneryservice;
	@Autowired
	DictioneryConverterService dictioneryConverterService;

	public void dictioneryApiHelper(String dictioneryList) {

		Dictioneries dictioneries = dictioneryConverterService.jsonConverterDictioneryApi(dictioneryList);
		if (dictionaryapivalidation.validateDictionery(dictioneries)) {
			List<Dictionery> dictioneryList1 = dictioneries.getDictionaries();
			dictioneryList1.forEach(dictionery -> {
				
				com.mastercard.galacticmerchant.model.Dictionery dictionery_model = new com.mastercard.galacticmerchant.model.Dictionery();
				dictionery_model.setGalacticCurrency(dictionery.getGalacticCurrency());
				dictionery_model.setRomanNumeral(dictionery.getRomanNumeral());
				Long id = dictionery_model.getId();
				List<com.mastercard.galacticmerchant.model.Dictionery> existingDictioneryList = dictioneryservice.findByGalacticQuantity(dictionery_model.getGalacticCurrency());
				if (existingDictioneryList.isEmpty()) {
					dictioneryservice.createDictionery(dictionery_model);
				} else {
					
				    dictioneryservice.deleteDictionery(existingDictioneryList.get(0).getId());
					dictioneryservice.createDictionery(dictionery_model);
				}

			});
		}

	}

	public JsonNode decimalApiHelper(String decimal) {

		StringBuffer romanNumeralsString = new StringBuffer();
		JsonNode jsonNode = null;

		GalanticQuantity galenticQuantity;

		ObjectMapper objectMapper = new ObjectMapper();
		galenticQuantity = dictioneryConverterService.jsonConverterDecimalApi(decimal);
		List<com.mastercard.galacticmerchant.model.Dictionery> galaticQuantityList =dictionaryapivalidation.validateforDecimalApi(galenticQuantity);
		
		galaticQuantityList.forEach(dictionery->
		{
			dictionery.getRomanNumeral();
			romanNumeralsString.append(dictionery.getRomanNumeral());
		});
			Map<String, String> map = new HashMap<String, String>();
			RomanCalculator romanCalculator = new RomanCalculator();
			map.put("decimalVaue",
					String.valueOf(romanCalculator.convertRomanNumeralsToInteger(romanNumeralsString.toString())));

			jsonNode = objectMapper.convertValue(map, JsonNode.class);

		return jsonNode;
}}
