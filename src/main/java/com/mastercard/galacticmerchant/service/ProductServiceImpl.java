package com.mastercard.galacticmerchant.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mastercard.galacticmerchant.exception.InvalidCreditException;
import com.mastercard.galacticmerchant.exception.InvalidJsonException;
import com.mastercard.galacticmerchant.exception.InvalidQuantityException;
import com.mastercard.galacticmerchant.exception.ProductNotFoundException;
import com.mastercard.galacticmerchant.exception.UnknownException;
import com.mastercard.jackson.model.ProductConfig;
import com.mastercard.jackson.model.ProductConfigs;
import com.mastercard.jackson.model.ProductCreditRequest;
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductConfigService productConfigService;
	@Autowired
	ProductConverterService productConverterService;
	@Autowired
	ProductApiValidationService productValidationService;
    @Override
	public void productConfigApiHelper(String productConfigList) {

		ProductConfigs productCOnfigs = productConverterService.jsonConverterProductCOnfigApi(productConfigList);
		productValidationService.validateProductConfig(productCOnfigs);
		List<ProductConfig> productConfigList1 = productCOnfigs.getProductConfigs();
		productConfigList1.forEach(productConfig -> {
			com.mastercard.galacticmerchant.model.ProductConfig productconfig_model = new com.mastercard.galacticmerchant.model.ProductConfig();
			productconfig_model.setProductName(productConfig.getProductName());
			productconfig_model.setQuantity(productConfig.getQuantity());
			productconfig_model.setCredit(productConfig.getCredit());
			List<com.mastercard.galacticmerchant.model.ProductConfig> existingProductList = productConfigService.findByProductName(productconfig_model.getProductName());
			if (existingProductList.isEmpty()) {
				productConfigService.createProductConfig(productconfig_model);
			} else {
				productConfigService.deleteProductConfig(existingProductList.get(0).getId());
				productConfigService.createProductConfig(productconfig_model);
			}
		});
	}
    @Override
	public JsonNode productCreditApiHelper(String productCredit) {

		ObjectMapper objectMapper = new ObjectMapper();

		ProductCreditRequest productCreditRequest = productConverterService
				.jsonConverterProductCreditApi(productCredit);
		

		productValidationService.validateProductCredit(productCreditRequest);
		List<com.mastercard.galacticmerchant.model.ProductConfig> productConfigList1 = productConfigService
				.findByProductName(productCreditRequest.getProductName());
		com.mastercard.galacticmerchant.model.ProductConfig productConfig = productConfigList1.get(0);
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("Credit", productConfig.getCredit());
		JsonNode jsonNode = objectMapper.convertValue(map, JsonNode.class);
		return jsonNode;

	}

}
