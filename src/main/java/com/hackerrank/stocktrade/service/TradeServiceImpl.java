package com.hackerrank.stocktrade.service;

import com.hackerrank.stocktrade.exceptions.AlreadyPresentException;
import com.hackerrank.stocktrade.exceptions.TradeNotFoundException;
import com.hackerrank.stocktrade.model.Trade;
import com.hackerrank.stocktrade.repository.TradeRepository;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TradeServiceImpl implements TradeService {

  @Autowired
  TradeRepository tradeRepository;

  @Override
  public void saveTrade(Trade trade) throws AlreadyPresentException {
    if (tradeRepository.existsById(trade.getId())) {
      throw new AlreadyPresentException();
    }
    tradeRepository.save(trade);
  }

  @Override
  public Trade getTradeById(Long id) throws TradeNotFoundException {
    Optional<Trade> trade = tradeRepository.findById(id);
    if (!trade.isPresent()) {
      throw new TradeNotFoundException();
    }
    return trade.get();
  }

  @Override
  public List<Trade> getAllTrade() {
    List<Trade> tradeList = tradeRepository.findAll();
    tradeList.sort(new Comparator<Trade>() {
      @Override
      public int compare(Trade o1, Trade o2) {
        return o1.getId().compareTo(o2.getId());
      }
    });
    return tradeList;
  }

  @Override
  public List<Trade> getTradeByUserId(Long id) throws TradeNotFoundException {
    List<Trade> tradeList = tradeRepository.findTradeByUserId(id);
    if (tradeList.isEmpty()) {
      throw new TradeNotFoundException();
    }
    return tradeList;
  }

  @Override
  public void deleteTrades() {
    tradeRepository.deleteAll();
  }

  @Override
  public List<Trade> getTradeBySymbol(String symbol) throws TradeNotFoundException {
    List<Trade> tradeList = tradeRepository.findTradeBySymbol(symbol);
    if (tradeList.isEmpty()) {
      throw new TradeNotFoundException();
    }
    return tradeList;
  }

  @Override
  public List<Trade> getTradeBySymbolAndUser(String symbol, Long id) throws TradeNotFoundException {
    List<Trade> tradeList = tradeRepository.findTradeByUserIdAndSymbol(id, symbol);
    if (tradeList.isEmpty()) {
      throw new TradeNotFoundException();
    }
    return tradeList;
  }
}
