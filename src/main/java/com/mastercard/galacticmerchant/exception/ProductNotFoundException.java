package com.mastercard.galacticmerchant.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProductNotFoundException extends RuntimeException {

  public ProductNotFoundException(String exception) {
    super(exception);
  }

}