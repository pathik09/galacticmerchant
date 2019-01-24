package com.mastercard.galacticmerchant.service;

import com.mastercard.jackson.model.ProductConfigs;
import com.mastercard.jackson.model.ProductCreditRequest;

/**
 * @author Pathik
 * This class is responsible for json conversion.
 *
 */
public interface ProductConverterService {

	ProductConfigs jsonConverterProductCOnfigApi(String productConfig);

	ProductCreditRequest jsonConverterProductCreditApi(String productCredit);
	

}
