package com.hackerrank.stocktrade.controller;

import com.hackerrank.stocktrade.exceptions.AlreadyPresentException;
import com.hackerrank.stocktrade.exceptions.TradeNotFoundException;
import com.hackerrank.stocktrade.model.Trade;
import com.hackerrank.stocktrade.service.TradeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/trades")
public class TradesController {

  @Autowired
  TradeService tradeService;

  @PostMapping
  @ResponseStatus(value = HttpStatus.CREATED)
  public void createTrade(@RequestBody Trade trade) throws AlreadyPresentException {
    tradeService.saveTrade(trade);
  }

  @GetMapping("/{id}")
  @ResponseStatus(value = HttpStatus.OK)
  public Trade getTrade(@PathVariable("id") Long id) throws TradeNotFoundException {
    return tradeService.getTradeById(id);
  }

  @GetMapping
  @ResponseStatus(value = HttpStatus.OK)
  public List<Trade> getAllTrade() {
    return tradeService.getAllTrade();
  }

  @GetMapping("/users/{userID}")
  @ResponseStatus(value = HttpStatus.OK)
  public List<Trade> getTradeByUser(@PathVariable("userID") Long id) throws TradeNotFoundException {
    return tradeService.getTradeByUserId(id);
  }

  @GetMapping("/stocks/{symbol}")
  @ResponseStatus(value = HttpStatus.OK)
  public List<Trade> getTradeByUser(@PathVariable("symbol") String symbol)
      throws TradeNotFoundException {
    return tradeService.getTradeBySymbol(symbol);
  }

  @GetMapping("/users/{userID}/stocks/{symbol}")
  @ResponseStatus(value = HttpStatus.OK)
  public List<Trade> getTradeByUser(@PathVariable("userID") Long id,
      @PathVariable("symbol") String symbol) throws TradeNotFoundException {
    return tradeService.getTradeBySymbolAndUser(symbol, id);
  }

}
