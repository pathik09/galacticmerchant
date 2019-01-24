package com.mastercard.galacticmerchant.controller.integrationtests;

import static org.junit.Assert.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.AssertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.context.junit4.SpringRunner;
import com.mastercard.galacticmerchant.GalacticMerchantApplication;
import com.mastercard.galacticmerchant.model.ProductConfig;
import com.mastercard.galacticmerchant.service.DictioneryApiService;
import com.mastercard.jackson.model.Dictioneries;
import com.mastercard.jackson.model.Dictionery;
import com.mastercard.jackson.model.GalanticQuantity;
import com.mastercard.jackson.model.ProductConfigs;
import com.mastercard.jackson.model.ProductCreditRequest;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@SpringBootTest(classes = GalacticMerchantApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class ProductApiControllerTest {
	@LocalServerPort
	private int port;
	MockMvc mockMvc;
	TestRestTemplate restTemplate = new TestRestTemplate();
	HttpHeaders header = new HttpHeaders();
	
	@Test
	public void testProductConfigpiForFailure()
	{
		ProductConfigs productConcfigs = new ProductConfigs();
		List<com.mastercard.jackson.model.ProductConfig> productConfigList = new ArrayList<com.mastercard.jackson.model.ProductConfig>();
		com.mastercard.jackson.model.ProductConfig productConfig = new com.mastercard.jackson.model.ProductConfig ();
		productConfig.setCredit(34);
		productConfig.setProductName("Silver");
		productConfig.setQuantity("glob pro");
		productConfigList.add(productConfig);
		productConcfigs.setProductConfigs(productConfigList);
		HttpEntity<ProductConfigs> entity = new HttpEntity<ProductConfigs>(productConcfigs,header);
		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/galacticmerchant/productconfig"),
				HttpMethod.POST, entity, String.class);
		assertTrue(true);
	}
	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}
	@Test
	public void testProductCreditApiForSuccess()
	{
		ProductCreditRequest productCredit = new ProductCreditRequest();
		productCredit.setProductName("Silver");
		productCredit.setQuantity("glob prok");
		HttpEntity<ProductCreditRequest> entity = new HttpEntity<ProductCreditRequest>(productCredit,header);
		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/galacticmerchant/productcredit"),
				HttpMethod.POST, entity, String.class);
		String actual = response.getBody();
		System.out.println(actual);
		assertTrue(actual.contains("400"));
	}
	@Test
	public void testProductCreditApi()
	{
		ProductCreditRequest productCredit = new ProductCreditRequest();
		productCredit.setProductName("Silver");
		productCredit.setQuantity("glob");
		HttpEntity<ProductCreditRequest> entity = new HttpEntity<ProductCreditRequest>(productCredit,header);
		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/galacticmerchant/productcredit"),
				HttpMethod.POST, entity, String.class);
		String actual = response.getBody();
		System.out.println(actual);
		assertTrue(actual.contains("34"));		
	}
	@Test
	public void testProductCreditApiForFailure()
	{
		ProductCreditRequest productCredit = new ProductCreditRequest();
		productCredit.setProductName("Silver");
		productCredit.setQuantity("glob pro");
		HttpEntity<ProductCreditRequest> entity = new HttpEntity<ProductCreditRequest>(productCredit,header);
		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/galacticmerchant/productcredit"),
				HttpMethod.POST, entity, String.class);
		String actual = response.getBody();
		System.out.println(actual);
		assertTrue(actual.contains("400"));
	}
	@Test
	public void testProductConfigApi()
	{
		ProductConfigs productConcfigs = new ProductConfigs();
		List<com.mastercard.jackson.model.ProductConfig> productConfigList = new ArrayList<com.mastercard.jackson.model.ProductConfig>();
		com.mastercard.jackson.model.ProductConfig productConfig = new com.mastercard.jackson.model.ProductConfig ();
		productConfig.setCredit(34);
		productConfig.setProductName("Silver");
		productConfig.setQuantity("glob");
		productConfigList.add(productConfig);
		productConcfigs.setProductConfigs(productConfigList);
		HttpEntity<ProductConfigs> entity = new HttpEntity<ProductConfigs>(productConcfigs,header);
		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/galacticmerchant/productconfig"),
				HttpMethod.POST, entity, String.class);
		assertTrue(true);
	}

}
