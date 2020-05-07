package com.hackerrank.stocktrade.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class AlreadyPresentException extends Exception {

  public AlreadyPresentException(){
    super("Trade Already Present");
  }
}
