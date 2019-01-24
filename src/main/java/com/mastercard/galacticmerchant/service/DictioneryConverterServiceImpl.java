package com.mastercard.galacticmerchant.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mastercard.galacticmerchant.exception.InvalidJsonException;
import com.mastercard.galacticmerchant.exception.UnknownException;
import com.mastercard.jackson.model.Dictioneries;
import com.mastercard.jackson.model.GalanticQuantity;

/**
 * @author pathik THis class is responsible for json conversion of the incoming
 *         json to pojo.
 *
 */
@Service
public class DictioneryConverterServiceImpl implements DictioneryConverterService {
	@Override
	public Dictioneries jsonConverterDictioneryApi(String dictioneryList) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();

			// convert json string to object

			Dictioneries dictioneries = objectMapper.readValue(dictioneryList, Dictioneries.class);
			return dictioneries;
		} catch (JsonParseException | JsonMappingException e) {
			{
				// TODO Auto-generated catch block
				throw new InvalidJsonException("Invalid Json Exception");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new UnknownException(e.getMessage());
		}

	}
	@Override
	public GalanticQuantity jsonConverterDecimalApi(String decimal) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();

			// convert json string to object

			GalanticQuantity galenticQuantity = objectMapper.readValue(decimal, GalanticQuantity.class);
			return galenticQuantity;
		} catch (JsonParseException | JsonMappingException e) {
			{
				// TODO Auto-generated catch block
				throw new InvalidJsonException("Invalid Json Exception");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new UnknownException(e.getMessage());
		}

	}


}
