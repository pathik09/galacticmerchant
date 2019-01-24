package com.mastercard.jackson.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"galacticCurrency",
"romanNumeral"
})
public class Dictionery {

@JsonProperty("galacticCurrency")
private String galacticCurrency;
@JsonProperty("romanNumeral")
private String romanNumeral;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("galacticCurrency")
public String getGalacticCurrency() {
return galacticCurrency;
}

@JsonProperty("galacticCurrency")
public void setGalacticCurrency(String galacticCurrency) {
this.galacticCurrency = galacticCurrency;
}

@JsonProperty("romanNumeral")
public String getRomanNumeral() {
return romanNumeral;
}

@JsonProperty("romanNumeral")
public void setRomanNumeral(String romanNumeral) {
this.romanNumeral = romanNumeral;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}