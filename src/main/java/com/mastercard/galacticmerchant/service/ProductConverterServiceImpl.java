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
import com.mastercard.jackson.model.ProductConfigs;
import com.mastercard.jackson.model.ProductCreditRequest;

/**
 * @author pathik THis class is responsible for json conversion of the incoming
 *         json to pojo.
 *
 */
@Service
public class ProductConverterServiceImpl implements ProductConverterService {
	@Override
	public ProductConfigs jsonConverterProductCOnfigApi(String productConfig) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();

			// convert json string to object

			ProductConfigs productConfigs = objectMapper.readValue(productConfig, ProductConfigs.class);
			return productConfigs;
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
	public ProductCreditRequest jsonConverterProductCreditApi(String productCredit) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();

			// convert json string to object

			ProductCreditRequest productCreditRequest = objectMapper.readValue(productCredit,
					ProductCreditRequest.class);

			return productCreditRequest;
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
