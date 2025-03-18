package org.example.stocktracking.Controller;

import org.example.stocktracking.Dto.StockInfoDto;
import org.example.stocktracking.Dto.StockInfoResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;
import java.util.List;

@Service
public class StockInfoApiClient {

    private final WebClient webClient;

    private static final String BASE_URL = "http://data-dbg.krx.co.kr/svc/apis/sto/stk_isu_base_info";
    private static final String AUTH_KEY = "38559DCA153E4D78B24872A40A414B3CD58F462B"; // 본인의 AUTH_KEY

    public StockInfoApiClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder
                .baseUrl(BASE_URL)
                .exchangeStrategies(ExchangeStrategies.builder()
                        .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(10*1024*1024))
                        .build())
                .build();
    }

    public List<StockInfoDto> fetchStockInfo(String basDd) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.queryParam("basDd", basDd).build())
                .header("Authorization", AUTH_KEY)
                .retrieve()
                .bodyToMono(StockInfoResponse.class)  // JSON 응답을 Java 객체로 변환
                .timeout(Duration.ofSeconds(10))  // ✅ 10초 타임아웃 설정
                .retry(3)  // ✅ 최대 3번 재시도
                .map(StockInfoResponse::getItems) // "OutBlock_1" 리스트 반환
                .block(); // 동기 처리
    }
}
