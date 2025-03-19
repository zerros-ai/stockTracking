package org.example.stocktracking.service;

import org.example.stocktracking.Controller.StockPriceApiClient;
import org.example.stocktracking.Dto.StockPriceDto;
import org.example.stocktracking.Entity.StockPrice;
import org.example.stocktracking.Entity.StockPriceId;
import org.example.stocktracking.repository.StockPriceRepository;
import org.example.stocktracking.util.TradingDayChecker;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockPriceService {
    private final StockPriceRepository stockPriceRepository;
    private final TradingDayChecker tradingDayChecker;
    private final StockPriceApiClient stockPriceApiClient;

    public StockPriceService(StockPriceRepository stockPriceRepository, StockPriceApiClient stockInfoApiClient, TradingDayChecker tradingDayChecker, StockPriceApiClient stockPriceApiClient) {
        this.stockPriceRepository = stockPriceRepository;
        this.tradingDayChecker = tradingDayChecker;
        this.stockPriceApiClient = stockPriceApiClient;
    }

    public void fetchAndUpdateStockPrice() {
        String tradingDay = tradingDayChecker.checkTradingDay();
        List<StockPriceDto> stockPrice = stockPriceApiClient.fetchStockPrice(tradingDay);

        for (StockPriceDto stockPriceDto : stockPrice) {
            StockPrice stock = new StockPrice();
            StockPriceId stockPriceId = new StockPriceId();
            stockPriceId.setBasDd(stockPriceDto.getBasDd());
            stockPriceId.setIsuCd(stockPriceDto.getIsuCd());
            stock.setId(stockPriceId);
            stock.setIsuNm(stockPriceDto.getIsuNm());
            stock.setMktNm(stockPriceDto.getMktNm());
            stock.setSectTpNm(stockPriceDto.getSectTpNm());
            stock.setTddClsprc(stockPriceDto.getTddClsprc());
            stock.setCmpprevddPrc(stockPriceDto.getCmpprevddPrc());
            stock.setFlucRt(stockPriceDto.getFlucRt());
            stock.setTddOpnprc(stockPriceDto.getTddOpnprc());
            stock.setTddHgprc(stockPriceDto.getTddHgprc());
            stock.setTddLwprc(stockPriceDto.getTddLwprc());
            stock.setAccTrdval(stockPriceDto.getAccTrdval());
            stock.setAccTrdvol(stockPriceDto.getAccTrdvol());
            stock.setMktcap(stockPriceDto.getMktcap());
            stock.setListShrs(stockPriceDto.getListShrs());
            stockPriceRepository.save(stock);
        }
    }
}
