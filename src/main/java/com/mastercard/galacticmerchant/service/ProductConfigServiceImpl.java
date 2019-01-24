package com.mastercard.galacticmerchant.service;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.mastercard.galacticmerchant.model.ProductConfig;

import com.mastercard.galaticmerchant.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductConfigServiceImpl implements ProductConfigService {

    @Autowired
    private ProductRepository productconfigRepository;

    @Override
    public ProductConfig createProductConfig(ProductConfig productconfig) {
        return productconfigRepository.save(productconfig);
    }

    @Override
    public Optional<ProductConfig> getProductConfig(Long id) {
        return productconfigRepository.findById(id);
    }

   

  
    @Override
    public void deleteProductConfig(Long id) {
        productconfigRepository.deleteById(id);
    }

	@Override
	public ProductConfig editProductConfig(ProductConfig productconfig) {
		return productconfigRepository.save(productconfig);
		
	}

	@Override
	public void deleteProductConfig(ProductConfig productconfig) {
		productconfigRepository.delete(productconfig);
		
	}

	@Override
	public long countProductConfigs() {
		// TODO Auto-generated method stub
		return productconfigRepository.count();
	}


	@Override
	public List<ProductConfig> findByProductName(String productName) {
		// TODO Auto-generated method stub
		return productconfigRepository.findByProductName(productName);
	}

   

   
}
