package com.mastercard.galacticmerchant.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidCreditException extends RuntimeException {

  public InvalidCreditException(String exception) {
    super(exception);
  }

}