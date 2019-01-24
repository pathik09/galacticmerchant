package com.mastercard.galacticmerchant.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidProductNameException extends RuntimeException {

  public InvalidProductNameException(String exception) {
    super(exception);
  }

}