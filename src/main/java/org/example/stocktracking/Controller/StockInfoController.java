package org.example.stocktracking.Controller;

import org.example.stocktracking.Entity.StockInfo;
import org.example.stocktracking.service.StockInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stock-info")
public class StockInfoController {
    private final StockInfoService stockInfoService;

    @Autowired
    public StockInfoController(StockInfoService stockInfoService) {
        this.stockInfoService = stockInfoService;
    }

    @PostMapping("/save")
    public StockInfo save() {
        stockInfoService.fetchAndUpdateStockInfo();
        return null;
    }
}
