package com.hackerrank.stocktrade.service;

import com.hackerrank.stocktrade.exceptions.AlreadyPresentException;
import com.hackerrank.stocktrade.exceptions.TradeNotFoundException;
import com.hackerrank.stocktrade.model.Trade;
import java.util.List;

public interface TradeService {

  void saveTrade(Trade trade) throws AlreadyPresentException;

  Trade getTradeById(Long id) throws TradeNotFoundException;

  List<Trade> getAllTrade();

  List<Trade> getTradeByUserId(Long id) throws TradeNotFoundException;

  void deleteTrades();

  List<Trade> getTradeBySymbol(String symbol) throws TradeNotFoundException;

  List<Trade> getTradeBySymbolAndUser(String symbol, Long id) throws TradeNotFoundException;

}
