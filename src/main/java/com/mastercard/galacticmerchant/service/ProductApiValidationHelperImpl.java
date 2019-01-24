package com.mastercard.galacticmerchant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mastercard.galacticmerchant.exception.InvalidCreditException;
import com.mastercard.galacticmerchant.exception.InvalidQuantityException;
import com.mastercard.galacticmerchant.exception.ProductNotFoundException;
import com.mastercard.galacticmerchant.model.Dictionery;
import com.mastercard.jackson.model.ProductConfig;
import com.mastercard.jackson.model.ProductConfigs;
import com.mastercard.jackson.model.ProductCreditRequest;
@Service
public class ProductApiValidationHelperImpl implements ProductApiValidationService {
	@Autowired
	ProductConfigService productConfigService;
	
	@Autowired
	DictioneryService dictioneryService;

	@Override
	public void validateProductConfig(ProductConfigs productConfigs) {
		List<ProductConfig> productConfigList1 = productConfigs.getProductConfigs();
		productConfigList1.forEach(productConfig -> {
			if (productConfig.getProductName() == "" || productConfig.getProductName() == null) {
				throw new ProductNotFoundException("Product Not  Found");
			} else if (productConfig.getQuantity() == "" || productConfig.getQuantity() == null) {
				throw new InvalidQuantityException("Quantity Invalid");
			} else if (productConfig.getCredit() == null) {
				throw new InvalidCreditException("Credit Invalid");
			}
			String[] quantityArray = productConfig.getQuantity().split(" ");
			for(String quantity:quantityArray)
			{
				List<Dictionery> QuantityList =  dictioneryService.findByGalacticQuantity(quantity);
				if(QuantityList.isEmpty())
				{
					throw new InvalidQuantityException("Quantity Invalid");
				}
			}
			
		});
		// TODO Auto-generated method stub
		
	}
	@Override
	public void validateProductCredit(ProductCreditRequest productCreditRequest)
	{
		if (productCreditRequest.getProductName() == "" || productCreditRequest.getProductName() == null) {
			throw new ProductNotFoundException("ProductName Empty");
		}
		List<com.mastercard.galacticmerchant.model.ProductConfig> productConfigList1 = productConfigService
				.findByProductName(productCreditRequest.getProductName());
		if (productConfigList1.size() == 0) {
			throw new ProductNotFoundException("Product Name does not exist.");
		}
		com.mastercard.galacticmerchant.model.ProductConfig productConfig = productConfigList1.get(0);

		if (!(productConfig.getQuantity().contentEquals(productCreditRequest.getQuantity()))) {
			throw new InvalidQuantityException("quantity not matching");
		}
		
	}
	
	


}
