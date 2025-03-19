package org.example.stocktracking.Controller;

import org.example.stocktracking.Entity.StockInfo;
import org.example.stocktracking.Entity.StockPrice;
import org.example.stocktracking.service.StockInfoService;
import org.example.stocktracking.service.StockPriceService;
import org.example.stocktracking.util.TradingDayChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stock-info")
public class StockInfoController {
    private final StockInfoService stockInfoService;
    private final TradingDayChecker tradingDayChecker;
    private final StockPriceService stockPriceService;

    @Autowired
    public StockInfoController(StockInfoService stockInfoService, TradingDayChecker tradingDayChecker, StockPriceService stockPriceService) {
        this.stockInfoService = stockInfoService;
        this.tradingDayChecker = tradingDayChecker;
        this.stockPriceService = stockPriceService;
    }

    @PostMapping("/saveInfo")
    public StockInfo saveInfo() {
        stockInfoService.fetchAndUpdateStockInfo();
        return null;
    }

    @PostMapping("/savePrice")
    public StockPrice savePrice() {
        stockPriceService.fetchAndUpdateStockPrice();
        return null;
    }

    @PostMapping("/test")
    public void test(@RequestParam String date) {
        stockPriceService.fetchAndUpdateStockPriceForMigration(date);
    }
}
