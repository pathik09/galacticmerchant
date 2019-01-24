package com.mastercard.galacticmerchant.service;

import com.mastercard.jackson.model.ProductConfigs;
import com.mastercard.jackson.model.ProductCreditRequest;

public interface ProductApiValidationService {
	/**
	 * @param productconfigs
	 * This method does various validations required for the ProductConfigApi.
	 */
	public void validateProductConfig(ProductConfigs productconfigs);

	/**
	 * @param productCredit
	 * THis method does various validations required for ProductCreditApi.
	 */
	void validateProductCredit(ProductCreditRequest productCredit);
}
