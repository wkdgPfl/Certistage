package com.example.certistage.service.external;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@RequiredArgsConstructor
public class QnetClient {

    private final RestTemplate restTemplate;

    @Value("${qnet.base-url}")
    private String baseUrl;

    @Value("${qnet.service-key}")
    private String serviceKey;

    /**
     * 국가기술자격 시험 일정 조회
     */
    public String getExamSchedule(int implYy) {
        String url = UriComponentsBuilder
                .fromHttpUrl(baseUrl)
                .queryParam("serviceKey", serviceKey)
                .queryParam("implYy", implYy)   // 필수 파라미터
                .queryParam("numOfRows", 10)    // 한 페이지 결과 수
                .queryParam("pageNo", 1)        // 페이지 번호
                .queryParam("dataFormat", "json") // json으로 받기
                .build(true)                    // 인코딩 유지
                .toUriString();

        // 일단은 String 찍어보기
        return restTemplate.getForObject(url, String.class);
    }
}
