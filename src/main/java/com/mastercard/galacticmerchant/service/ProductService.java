package com.mastercard.galacticmerchant.service;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * @author Pathik
 * This class is responsible for calling spring data api.
 *
 */
public interface ProductService {
	/**
	 * @param productCredit
	 * @return
	 * THis method is created as a helper for ProductCreditApi.
	 */
	public JsonNode productCreditApiHelper(String productCredit);
	
	/**
	 * @param productConfigList
	 * This method is created as a helper for ProductConfigApi.
	 */
	public void productConfigApiHelper(String productConfigList);

}
