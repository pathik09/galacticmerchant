package com.mastercard.galacticmerchant.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Dictionery {
	  @Id
	  @GeneratedValue
	  private Long id;
	    private String galacticCurrency;
	    private String romanNumeral;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getGalacticCurrency() {
			return galacticCurrency;
		}
		public void setGalacticCurrency(String galacticCurrency) {
			this.galacticCurrency = galacticCurrency;
		}
		public String getRomanNumeral() {
			return romanNumeral;
		}
		public void setRomanNumeral(String romanNumeral) {
			this.romanNumeral = romanNumeral;
		}
	
	
	

}
