
package com.hackerrank.stocktrade.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class TradeNotFoundException extends Exception{

  public TradeNotFoundException() {
    super("Trade Not Found");
  }
}
