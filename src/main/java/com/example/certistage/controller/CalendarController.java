package com.example.certistage.controller;

import com.example.certistage.dto.CalendarEventDto;
import com.example.certistage.service.CalendarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/calendar")
public class CalendarController {

    private final CalendarService calendarService;

    /**
     * 전체 일정 조회 (옵션: 검색)
     * GET /api/calendar/events?year=2025&keyword=컴공
     */
    @GetMapping("/events")
    public ResponseEntity<List<CalendarEventDto>> getAllEvents(
            @RequestParam(defaultValue = "2025") int year,
            @RequestParam(required = false) String keyword
    ) {
        List<CalendarEventDto> events = calendarService.getExamEvents(year);

        // 검색 필터링 적용
        events = calendarService.filterEventsByKeyword(events, keyword);

        return ResponseEntity.ok(events);
    }

    /**
     * 특정 날짜 일정 조회
     * GET /api/calendar/date/2025-11-21?keyword=컴공
     */
    @GetMapping("/date/{date}")
    public ResponseEntity<List<CalendarEventDto>> getSchedulesByDate(
            @PathVariable String date,
            @RequestParam(required = false) String keyword
    ) {
        LocalDate parsed = LocalDate.parse(date);

        List<CalendarEventDto> events = calendarService.getEventsByDate(parsed);

        // 검색 필터링 적용
        events = calendarService.filterEventsByKeyword(events, keyword);

        return ResponseEntity.ok(events);
    }

    /**
     * 특정 월 일정 조회
     * GET /api/calendar/month/2025/11?keyword=컴공
     */
    @GetMapping("/month/{year}/{month}")
    public ResponseEntity<List<CalendarEventDto>> getSchedulesByMonth(
            @PathVariable int year,
            @PathVariable int month,
            @RequestParam(required = false) String keyword
    ) {
        List<CalendarEventDto> events = calendarService.getEventsByMonth(year, month);

        // 검색 필터링 적용
        events = calendarService.filterEventsByKeyword(events, keyword);

        return ResponseEntity.ok(events);
    }
}
