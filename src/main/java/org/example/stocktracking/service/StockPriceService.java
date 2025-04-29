package org.example.stocktracking.service;

import lombok.extern.slf4j.Slf4j;
import org.example.stocktracking.client.StockPriceApiClient;
import org.example.stocktracking.Dto.StockPriceDto;
import org.example.stocktracking.Entity.StockPrice;
import org.example.stocktracking.Entity.StockPriceId;
import org.example.stocktracking.repository.jpa.StockPriceRepository;
import org.example.stocktracking.repository.mybatis.StockPriceMapper;
import org.example.stocktracking.util.TradingDayChecker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Slf4j
@Service
public class StockPriceService {
    private final StockPriceRepository stockPriceRepository;
    private final TradingDayChecker tradingDayChecker;
    private final StockPriceApiClient stockPriceApiClient;
    private final StockPriceMapper stockPriceMapper;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    public StockPriceService(StockPriceRepository stockPriceRepository, StockPriceApiClient stockInfoApiClient, TradingDayChecker tradingDayChecker, StockPriceApiClient stockPriceApiClient, StockPriceMapper stockPriceMapper) {
        this.stockPriceRepository = stockPriceRepository;
        this.tradingDayChecker = tradingDayChecker;
        this.stockPriceApiClient = stockPriceApiClient;
        this.stockPriceMapper = stockPriceMapper;
    }

    public List<StockPrice> getStockPrices(String basDd, String isuCd) {
        logger.info("parameter-> "+basDd+" "+isuCd);
       return stockPriceMapper.findByIsuCdAndDate(basDd, isuCd);
    }

    @Scheduled(cron = "0 0 10 * * MON-FRI")
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

    public void fetchAndUpdateStockPriceForMigration(String tradingDay) {
        LocalDate yesterday = LocalDate.now().minusDays(1);
        LocalDate date = LocalDate.parse(tradingDay, DateTimeFormatter.ofPattern("yyyyMMdd"));
        while(date.isBefore(yesterday)) {
            if(tradingDayChecker.checkTradingDayForMigration(date.format(DateTimeFormatter.ofPattern("yyyyMMdd")))) {
                List<StockPriceDto> stockPrice = stockPriceApiClient.fetchStockPrice(date.format(DateTimeFormatter.ofPattern("yyyyMMdd")));
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
            date = date.plusDays(1);
        }

    }
}
