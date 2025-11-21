package com.example.certistage.service;

import com.example.certistage.dto.CalendarEventDto;
import com.example.certistage.dto.ExamApiResponse;
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

    /**
     * 전체 일정 리스트 생성
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

    private void addEvent(List<CalendarEventDto> events, String date, String title, String type, String description) {
        if (date != null && !date.isEmpty()) {
            events.add(new CalendarEventDto(date, title, type, description));
        }
    }

    /**
     * 특정 날짜만 필터링
     */
    public List<CalendarEventDto> getEventsByDate(LocalDate date) {
        String target = date.toString().replace("-", ""); // yyyyMMdd 형태로 변환

        return getExamEvents(date.getYear()).stream()
                .filter(e -> e.getDate().equals(target))
                .collect(Collectors.toList());
    }

    /**
     * 특정 월만 필터링
     */
    public List<CalendarEventDto> getEventsByMonth(int year, int month) {

        String prefix = String.format("%04d%02d", year, month); // yyyyMM

        return getExamEvents(year).stream()
                .filter(e -> e.getDate().startsWith(prefix))
                .collect(Collectors.toList());
    }
}
