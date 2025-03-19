package org.example.stocktracking.util;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

@Service
public class TradingDayChecker {

    private static final String HOLIDAY_API_URL = "http://apis.data.go.kr/B090041/openapi/service/SpcdeInfoService/getRestDeInfo";
    private final WebClient webClient;
    private final StockApiProperties stockApiProperties;

    public TradingDayChecker(WebClient.Builder webClientBuilder, StockApiProperties stockApiProperties) {
        this.webClient = webClientBuilder.baseUrl(HOLIDAY_API_URL).build();
        this.stockApiProperties = stockApiProperties;
    }

    // ✅ 한국 공휴일 조회 API 호출하여 공휴일 리스트 반환
    public Set<LocalDate> getHolidays(int year, int month) {
        Set<LocalDate> holidaySet = new HashSet<>();
        // 1월부터 12월까지 조회
            String response = webClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .queryParam("solYear", year)
                            .queryParam("solMonth", String.format("%02d", month)) // 01, 02, ... 12 형식 유지
                            .queryParam("_type", "json")
                            .queryParam("numOfRows", "100")
                            .queryParam("ServiceKey", stockApiProperties.getAuthKey("gonggong"))
                            .build())
                    .retrieve()
                    .bodyToMono(String.class)
                    .block(); // 동기 처리

            if (response != null && response.contains("\"isHoliday\":\"Y\"")) {
                String[] items = response.split("\\{");
                for (String item : items) {
                    if (item.contains("\"isHoliday\":\"Y\"")) {
                        String locdateStr = item.split("\"locdate\":")[1].split(",")[0]; // locdate 값 추출
                        LocalDate holiday = LocalDate.parse(locdateStr, DateTimeFormatter.ofPattern("yyyyMMdd"));
                        holidaySet.add(holiday);
                    }
                }
            }
        return holidaySet;
    }

    //주말이면 false 평일이면 true 반환
    public static boolean isYesterdayWeekend(LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek(); // 요일 가져오기
        return dayOfWeek != DayOfWeek.SATURDAY && dayOfWeek != DayOfWeek.SUNDAY;
    }
    // ✅ 한국 공휴일이면 `false` 반환
    public boolean isHoliday(LocalDate date) {
        int year = date.getYear();
        int month = date.getMonthValue();
        Set<LocalDate> holidays = getHolidays(year,month);
        return holidays.contains(date);
    }

    // ✅ 최종적으로 주말 또는 공휴일이면 `false`, 거래 가능일이면 `true` 반환
    public String checkTradingDay() {
        LocalDate yesterday = LocalDate.now().minusDays(1);
        while (true) {
            boolean isWeekend = !isYesterdayWeekend(yesterday);
            boolean isHoliday = isHoliday(yesterday);
            // ✅ 주말도 아니고 공휴일도 아니면 거래 가능일
            if (!isWeekend && !isHoliday) {
                System.out.println("DEBUG: Trading day found = " + yesterday);
                return yesterday.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
            }
            // ✅ 주말 또는 공휴일이면 하루 전으로 이동
            yesterday = yesterday.minusDays(1);
        }
    }

    public boolean checkTradingDayForMigration(String tradingDay) {
            boolean isWeekend = !isYesterdayWeekend(LocalDate.parse(tradingDay,DateTimeFormatter.ofPattern("yyyyMMdd")));
            boolean isHoliday = isHoliday(LocalDate.parse(tradingDay,DateTimeFormatter.ofPattern("yyyyMMdd")));
            // ✅ 주말도 아니고 공휴일도 아니면 거래 가능일
        return !isWeekend && !isHoliday;
    }

}
