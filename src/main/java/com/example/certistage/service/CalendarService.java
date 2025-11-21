package com.example.certistage.service;

import com.example.certistage.dto.CalendarEventDto;
import com.example.certistage.dto.ExamApiResponse;
import com.example.certistage.entity.CertificateKeyword;
import com.example.certistage.repository.CertificateKeywordRepository;
import com.example.certistage.service.external.QnetClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CalendarService {

    private final QnetClient qnetClient;
    private final CertificateKeywordRepository keywordRepository;

    /**
     * Q-net 전체 일정 조회
     */
    public List<CalendarEventDto> getExamEvents(int year) {
        ExamApiResponse response = qnetClient.getExamScheduleAsDto(year);

        List<CalendarEventDto> events = new ArrayList<>();
        if (response == null || response.getBody() == null) return events;

        for (ExamApiResponse.ExamItem item : response.getBody().getItems()) {

            addEvent(events, item.getDocExamStartDt(), "필기시험 시작", "DOC", item.getDescription());
            addEvent(events, item.getDocExamEndDt(), "필기시험 종료", "DOC", item.getDescription());
            addEvent(events, item.getPracExamStartDt(), "실기시험 시작", "PRAC", item.getDescription());
            addEvent(events, item.getPracExamEndDt(), "실기시험 종료", "PRAC", item.getDescription());
        }

        return events;
    }

    /**
     * 이벤트 객체 생성 함수
     */
    private void addEvent(List<CalendarEventDto> events, String date, String title, String type, String description) {
        if (date != null && !date.isEmpty()) {
            events.add(new CalendarEventDto(date, title, type, description));
        }
    }

    /**
     * 특정 날짜별 일정 조회
     */
    public List<CalendarEventDto> getEventsByDate(LocalDate date) {
        String target = date.toString().replace("-", ""); // yyyyMMdd

        return getExamEvents(date.getYear())
                .stream()
                .filter(e -> e.getDate().equals(target))
                .collect(Collectors.toList());
    }

    /**
     * 특정 월 일정 조회
     */
    public List<CalendarEventDto> getEventsByMonth(int year, int month) {

        String prefix = String.format("%04d%02d", year, month); // yyyyMM

        return getExamEvents(year)
                .stream()
                .filter(e -> e.getDate().startsWith(prefix))
                .collect(Collectors.toList());
    }

    /**
     * 검색 필터링 (전공/분야 매핑 + 자격증명 검색)
     */
    public List<CalendarEventDto> filterEventsByKeyword(List<CalendarEventDto> events, String keyword) {
        if (keyword == null || keyword.isEmpty()) return events;

        String lowerKeyword = keyword.toLowerCase();

        // 1) 전공/분야 키워드 DB 조회
        List<CertificateKeyword> mappedCerts = keywordRepository.findByKeyword(keyword);

        // 2) 전공/분야 검색이면 certificate_name 기반으로 필터링
        if (!mappedCerts.isEmpty()) {
            List<String> certificateNames = mappedCerts.stream()
                    .map(c -> c.getCertificateName().toLowerCase())
                    .toList();

            return events.stream()
                    .filter(e ->
                            certificateNames.stream()
                                    .anyMatch(cert -> e.getDescription().toLowerCase().contains(cert))
                    )
                    .collect(Collectors.toList());
        }

        // 3) 매핑 없으면 기존의 description.contains 방식
        return events.stream()
                .filter(e ->
                        e.getDescription().toLowerCase().contains(lowerKeyword) ||
                                e.getTitle().toLowerCase().contains(lowerKeyword)
                )
                .collect(Collectors.toList());
    }
}
