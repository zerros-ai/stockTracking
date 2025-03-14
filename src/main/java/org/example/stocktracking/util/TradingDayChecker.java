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
    private static final String SERVICE_KEY = "SW%2FbjwaSRIBzdda3Rd623GLCMgtSwOT%2Fp3S8FtTgvugaR63aYx5KbmYnMfRqZNYQkQG1J8aeNwRgg865WvDvNw%3D%3D"; // API 키 입력
    private final WebClient webClient;

    public TradingDayChecker(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(HOLIDAY_API_URL).build();
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
                            .queryParam("ServiceKey", SERVICE_KEY)
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
    public boolean checkTradingDay() {
        LocalDate yesterday = LocalDate.now().minusDays(1);
        boolean isWeekend = !isYesterdayWeekend(yesterday);
        boolean isHoliday = isHoliday(yesterday);

        System.out.println("DEBUG: Yesterday = " + yesterday + ", Weekend = " + isWeekend + ", Holiday = " + isHoliday);
        return !(isWeekend || isHoliday); // 주말 또는 공휴일이면 false, 아니면 true
    }
}
