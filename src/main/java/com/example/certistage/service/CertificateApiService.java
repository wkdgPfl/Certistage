package com.example.certistage.service;

import com.example.certistage.entity.ExamSchedule;
import com.example.certistage.repository.ExamScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CertificateApiService {

    private final WebClient webClient;
    private final ExamScheduleRepository examScheduleRepository;

    @Value("${spring.odcloud.api-key}")
    private String serviceKey;

    private final String BASE_URL = "https://api.odcloud.kr/api/3038404/v1/uddi:cde11ae6-35ca-47b8-98cb-ad71146c6fd9";

    public void fetchAndSaveSchedules() {

        Map<String, Object> response = webClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder
                                .path(BASE_URL)
                                .queryParam("page", 1)
                                .queryParam("perPage", 500)
                                .queryParam("serviceKey", serviceKey)
                                .build()
                )
                .retrieve()
                .bodyToMono(Map.class)
                .block();

        List<Map<String, String>> data = (List<Map<String, String>>) response.get("data");

        for (Map<String, String> item : data) {
            // 예: 날짜 "2024-06-24" 형태로 제공됨
            LocalDate date = parseDate(item.get("내용"));

            examScheduleRepository.save(
                    ExamSchedule.builder()
                            .certificateName(item.get("종목명"))
                            .category(item.get("항목"))
                            .content(item.get("내용"))
                            .examDate(date)
                            .build()
            );
        }
    }

    private LocalDate parseDate(String content) {
        try {
            return LocalDate.parse(content.substring(0, 10));
        } catch (Exception e) {
            return null;
        }
    }
}
