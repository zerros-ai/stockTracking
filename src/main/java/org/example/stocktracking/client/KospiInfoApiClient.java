package org.example.stocktracking.client;

import org.example.stocktracking.Dto.KospiInfoDto;
import org.example.stocktracking.Dto.KospiInfoResponse;
import org.example.stocktracking.util.StockApiProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;
import java.util.List;

@Service
public class KospiInfoApiClient {
    private final WebClient webClient;

    private static final String BASE_URL = "http://data-dbg.krx.co.kr/svc/apis/idx/kospi_dd_trd";
    private final StockApiProperties properties;


    public KospiInfoApiClient(WebClient.Builder webClient, StockApiProperties properties) {
        this.webClient = webClient
                .baseUrl(BASE_URL)
                .exchangeStrategies(ExchangeStrategies.builder()
                .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(10*1024*1024))
                        .build())
                .build();
        this.properties = properties;
    }

    public List<KospiInfoDto> fetchKospiInfo(String basDd) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.queryParam("basDd", basDd).build())
                .header("Authorization", properties.getAuthKey("krx"))
                .retrieve()
                .bodyToMono(KospiInfoResponse.class)  // JSON 응답을 Java 객체로 변환
                .timeout(Duration.ofSeconds(30))  // ✅ 30초 타임아웃 설정
                .retry(3)  // ✅ 최대 3번 재시도
                .map(KospiInfoResponse::getItems) // "OutBlock_1" 리스트 반환
                .block(); // 동기 처리
    }

}
