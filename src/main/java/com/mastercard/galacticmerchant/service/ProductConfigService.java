package com.mastercard.galacticmerchant.service;



import java.util.List;
import java.util.Optional;

import com.mastercard.galacticmerchant.model.ProductConfig;



public interface ProductConfigService {

   

    Optional<ProductConfig> getProductConfig(Long id);

    ProductConfig editProductConfig(ProductConfig productConfig);

    void deleteProductConfig(ProductConfig productconfig);

    void deleteProductConfig(Long id);
    
    List<ProductConfig> findByProductName(String productName);

   

    long countProductConfigs();

	ProductConfig createProductConfig(ProductConfig productconfig_model);
	
	
}
