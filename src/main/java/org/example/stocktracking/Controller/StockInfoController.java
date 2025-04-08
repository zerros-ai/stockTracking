package org.example.stocktracking.Controller;

import org.example.stocktracking.Entity.StockInfo;
import org.example.stocktracking.Entity.StockPrice;
import org.example.stocktracking.service.KospiInfoService;
import org.example.stocktracking.service.StockInfoService;
import org.example.stocktracking.service.StockPriceService;
import org.example.stocktracking.util.TradingDayChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stock-info")
public class StockInfoController {
    private final StockInfoService stockInfoService;
    private final TradingDayChecker tradingDayChecker;
    private final StockPriceService stockPriceService;
    private final KospiInfoService kospiInfoService;

    @Autowired
    public StockInfoController(StockInfoService stockInfoService, TradingDayChecker tradingDayChecker, StockPriceService stockPriceService, KospiInfoService kospiInfoService) {
        this.stockInfoService = stockInfoService;
        this.tradingDayChecker = tradingDayChecker;
        this.stockPriceService = stockPriceService;
        this.kospiInfoService = kospiInfoService;
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

    @PostMapping("/saveKospi")
    public StockPrice saveKospi() {
        kospiInfoService.fetchAndUpdateKospiInfo();
        return null;
    }

    @PostMapping("/test")
    public void test(@RequestParam String date) {
        stockPriceService.fetchAndUpdateStockPriceForMigration(date);
    }

    @PostMapping("/kospiMigration")
    public void kospiMigration(@RequestParam String date) {
        kospiInfoService.fetchAndUpdateKospiInfoForMigration(date);
    }

    @GetMapping("/getStockInfoByName")
    public List<StockInfo> getStockInfoByName(String name) {
      return stockInfoService.getStckInfoByName(name);
    }

    @GetMapping("/getStockInfoByIsuCd")
    public List<StockInfo> getStockInfoByCd(String isuCd) {
        return stockInfoService.getStckInfoByName(isuCd);
    }
}
