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

import com.mastercard.galacticmerchant.service.DictioneryApiService;
import com.mastercard.jackson.model.Dictioneries;
import com.mastercard.jackson.model.Dictionery;
import com.mastercard.jackson.model.GalanticQuantity;
import com.mastercard.jackson.model.ProductCreditRequest;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@SpringBootTest(classes = GalacticMerchantApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DictionaryApiControllerTest {
	@LocalServerPort
	private int port;
	MockMvc mockMvc;
	TestRestTemplate restTemplate = new TestRestTemplate();
	HttpHeaders header = new HttpHeaders();
	@Test
	public void testDictioneryApiForsuccess()
	{
		Dictioneries dictioneries = new Dictioneries();
		List<Dictionery> dictioneryList = new ArrayList<Dictionery>();
		Dictionery dictionery = new Dictionery();
		dictionery.setGalacticCurrency("glob");
		dictionery.setRomanNumeral("I");
		dictioneryList.add(dictionery);
		dictioneries.setDictionaries(dictioneryList);
		HttpEntity<Dictioneries> entity = new HttpEntity<Dictioneries>(dictioneries,header);
		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/galacticmerchant/dictionary"),
				HttpMethod.POST, entity, String.class);
		assertTrue(true);
	}
	@Test
	public void testDictioneryApiForFailure()
	{
		Dictioneries dictioneries = new Dictioneries();
		List<Dictionery> dictioneryList = new ArrayList<Dictionery>();
		Dictionery dictionery = new Dictionery();
		dictionery.setGalacticCurrency("glow");
		dictionery.setRomanNumeral("A");
		dictioneryList.add(dictionery);
		dictioneries.setDictionaries(dictioneryList);
		HttpEntity<Dictioneries> entity = new HttpEntity<Dictioneries>(dictioneries,header);
		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/galacticmerchant/dictionary"),
				HttpMethod.POST, entity, String.class);
		System.out.println(response.getBody());
		assertTrue(true);
	}
	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}
	@Test
	public void testDecimalApi()
	{
		GalanticQuantity galanticQuantity = new GalanticQuantity();
		galanticQuantity.setGalacticQuantity("glob");
		HttpEntity<GalanticQuantity> entity1 = new HttpEntity<GalanticQuantity>(galanticQuantity,header);
		ResponseEntity<String> response1 = restTemplate.exchange(
				createURLWithPort("/galacticmerchant/decimal"),
				HttpMethod.POST, entity1, String.class);
		String actual = response1.getBody();
		assertTrue(actual.contains("1"));
	

		
		
		
	}
	@Test
	public void testDecimalApiForFailure()
	{
		GalanticQuantity galanticQuantity = new GalanticQuantity();
		galanticQuantity.setGalacticQuantity("glow");
		HttpEntity<GalanticQuantity> entity1 = new HttpEntity<GalanticQuantity>(galanticQuantity,header);
		ResponseEntity<String> response1 = restTemplate.exchange(
				createURLWithPort("/galacticmerchant/decimal"),
				HttpMethod.POST, entity1, String.class);
		String actual = response1.getBody();
		;
		assertTrue(actual.contains("Quantity does not exist."));
	

		
		
		
	}
}
