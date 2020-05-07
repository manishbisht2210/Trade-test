package com.hackerrank.stocktrade.repository;

import com.hackerrank.stocktrade.model.Trade;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradeRepository extends JpaRepository<Trade, Long> {

  List<Trade> findTradeByUserId(Long id);

  List<Trade> findTradeBySymbol(String symbol);

  List<Trade> findTradeByUserIdAndSymbol(Long id, String symbol);

}
