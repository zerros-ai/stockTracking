package org.example.stocktracking.service;

import org.example.stocktracking.Controller.StockPriceApiClient;
import org.example.stocktracking.repository.StockPriceRepository;
import org.example.stocktracking.util.TradingDayChecker;
import org.springframework.stereotype.Service;

@Service
public class StockPriceService {
    private final StockPriceRepository stockPriceRepository;
    private final StockPriceApiClient stockInfoApiClient;
    private final TradingDayChecker tradingDayChecker;

    public StockPriceService(StockPriceRepository stockPriceRepository, StockPriceApiClient stockInfoApiClient, TradingDayChecker tradingDayChecker) {
        this.stockPriceRepository = stockPriceRepository;
        this.stockInfoApiClient = stockInfoApiClient;
        this.tradingDayChecker = tradingDayChecker;
    }
}
