package com.mastercard.galacticmerchant.controller;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mastercard.galacticmerchant.exception.InvalidCreditException;
import com.mastercard.galacticmerchant.exception.InvalidJsonException;
import com.mastercard.galacticmerchant.exception.InvalidQuantityException;
import com.mastercard.galacticmerchant.exception.ProductNotFoundException;
import com.mastercard.galacticmerchant.service.DictioneryService;
import com.mastercard.galacticmerchant.service.ProductConfigService;
import com.mastercard.galacticmerchant.service.ProductService;
import com.mastercard.jackson.model.Dictioneries;
import com.mastercard.jackson.model.ProductConfig;
import com.mastercard.jackson.model.ProductConfigs;
import com.mastercard.jackson.model.ProductCreditRequest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * @author Pathik
 *
 */
@RestController
@RequestMapping("galacticmerchant")
public class ProductApiController {
	@Autowired
	ProductService productService;

	/**
	 * @param productConfigList
	 */
	@RequestMapping(value = "/productconfig", method = RequestMethod.POST, consumes = "application/json")
	public void productConfig(@RequestBody String productConfigList) {

		productService.productConfigApiHelper(productConfigList);
	}

	/**
	 * @param productCredit
	 */
	@RequestMapping(value = "/productcredit", method = RequestMethod.POST, consumes = "application/json")
	public JsonNode decimal(@RequestBody String productCredit) {
		return productService.productCreditApiHelper(productCredit);
	}

}