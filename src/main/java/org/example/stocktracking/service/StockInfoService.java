package org.example.stocktracking.service;

import org.example.stocktracking.client.StockInfoApiClient;
import org.example.stocktracking.Dto.StockInfoDto;
import org.example.stocktracking.Entity.StockInfo;
import org.example.stocktracking.repository.StockInfoRepository;
import org.example.stocktracking.util.TradingDayChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class StockInfoService {
    private final StockInfoRepository respository;
    private final StockInfoApiClient stockInfoApiClient;
    private final TradingDayChecker tradingDayChecker;

    @Autowired
    public StockInfoService(StockInfoRepository respository, StockInfoApiClient stockInfoApiClient, TradingDayChecker tradingDayChecker) {
        this.respository = respository;
        this.stockInfoApiClient = stockInfoApiClient;
        this.tradingDayChecker = tradingDayChecker;
    }
    @Scheduled(cron = "0 0 9 * * MON-FRI")
    public void fetchAndUpdateStockInfo() {
        String tradingDay = tradingDayChecker.checkTradingDay();
        List<StockInfoDto> stockList = stockInfoApiClient.fetchStockInfo(tradingDay);

        for(StockInfoDto stockInfoDto : stockList) {
            StockInfo stock = new StockInfo();
            if (stockInfoDto.getIsuCd() == null || stockInfoDto.getIsuCd().isEmpty()) {
                throw new IllegalArgumentException("ISU_CD (종목 코드) cannot be null");
            }
            stock.setIsuCd(stockInfoDto.getIsuCd());
            stock.setIsuSrtCd(stockInfoDto.getIsuSrtCd());
            stock.setIsuNm(stockInfoDto.getIsuNm());
            stock.setIsuAbbrv(stockInfoDto.getIsuAbbrv());
            stock.setIsuEngNm(stockInfoDto.getIsuEngNm());
            stock.setMktTpNm(stockInfoDto.getMktTpNm());
            stock.setSecugrpNm(stockInfoDto.getSecugrpNm());
            stock.setSectTpNm(stockInfoDto.getSectTpNm());
            stock.setKindStkcertTpNm(stockInfoDto.getKindStkcertTpNm());
            stock.setParval(String.valueOf(stockInfoDto.getParval()));
            stock.setListShrs(stockInfoDto.getListShr());

            // LIST_DD 값이 YYYYMMDD 형태이므로 LocalDate로 변환
//            stock.setListDd(LocalDate.parse(stockInfoDto.getListDd(), DateTimeFormatter.ofPattern("yyyyMMdd")));
            if (stockInfoDto.getListDd() != null && !stockInfoDto.getListDd().isEmpty()) {
                stock.setListDd(LocalDate.parse(stockInfoDto.getListDd(), DateTimeFormatter.ofPattern("yyyyMMdd")));
            } else {
                System.out.println("WARN: LIST_DD is null or empty for ISU_CD: " + stockInfoDto.getIsuCd());
                stock.setListDd(null);  // 또는 기본 날짜 설정
            }

            respository.save(stock);
        }
    }
}

