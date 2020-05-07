package com.hackerrank.stocktrade.controller;

import com.hackerrank.stocktrade.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/erase")
public class ResourcesController {

  @Autowired
  TradeService tradeService;

  @DeleteMapping
  @ResponseStatus(value = HttpStatus.OK)
  public void deleteTrade() {
    tradeService.deleteTrades();
  }

}
