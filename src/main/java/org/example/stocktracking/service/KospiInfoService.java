package org.example.stocktracking.service;

import org.example.stocktracking.Dto.KospiInfoDto;
import org.example.stocktracking.Dto.KospiInfoResponse;
import org.example.stocktracking.Entity.KospiInfo;
import org.example.stocktracking.Entity.KospiInfoId;
import org.example.stocktracking.client.KospiInfoApiClient;
import org.example.stocktracking.repository.KospiInfoRespository;
import org.example.stocktracking.util.TradingDayChecker;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KospiInfoService {
    private final KospiInfoRespository kospiInfoRespository;
    private final TradingDayChecker tradingDayChecker;
    private final KospiInfoApiClient kospiInfoApiClient;

    public KospiInfoService(KospiInfoRespository kospiInfoRespository, TradingDayChecker tradingDayChecker, KospiInfoApiClient kospiInfoApiClient) {
        this.kospiInfoRespository = kospiInfoRespository;
        this.tradingDayChecker = tradingDayChecker;
        this.kospiInfoApiClient = kospiInfoApiClient;
    }
    @Scheduled(cron = "0 0 9 * * MON-FRI")
    public void fetchAndUpdateKospiInfo() {
        String tradingDay = tradingDayChecker.checkTradingDay();
        List<KospiInfoDto>  koipiInfo = kospiInfoApiClient.fetchKospiInfo(tradingDay);

        for(KospiInfoDto kospiInfoDto : koipiInfo) {
            KospiInfo kospi = new KospiInfo();
            KospiInfoId kospiInfoId = new KospiInfoId();
            kospiInfoId.setBasDd(kospiInfoDto.getBasDd());
            kospiInfoId.setIdxClss(kospiInfoDto.getIdxClss());
            kospiInfoId.setIdxNm(kospiInfoDto.getIdxNm());
            kospi.setId(kospiInfoId);
            kospi.setClsprcIdx(kospiInfoDto.getClsprcIdx());
            kospi.setCmpprevddIdx(kospiInfoDto.getCmpprevddIdx());
            kospi.setFlucRt(kospiInfoDto.getFlucRt());
            kospi.setOpnprcIdx(kospiInfoDto.getOpnprcIdx());
            kospi.setHgprcIdx(kospiInfoDto.getHgprcIdx());
            kospi.setLwprcIdx(kospiInfoDto.getLwprcIdx());
            kospi.setAccTrdval(kospiInfoDto.getAccTrdval());
            kospi.setAccTrdvol(kospiInfoDto.getAccTrdvol());
            kospi.setMktcap(kospiInfoDto.getMktcap());
            kospiInfoRespository.save(kospi);
        }
    }
}
