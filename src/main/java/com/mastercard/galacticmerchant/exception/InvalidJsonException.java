package com.mastercard.galacticmerchant.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidJsonException extends RuntimeException {

  public InvalidJsonException(String exception) {
    super(exception);
  }

}