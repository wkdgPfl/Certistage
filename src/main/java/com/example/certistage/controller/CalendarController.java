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
     * 전체 시험 일정 목록 조회
     * GET /api/calendar/events?year=2025
     */
    @GetMapping("/events")
    public ResponseEntity<List<CalendarEventDto>> getAllEvents(
            @RequestParam(defaultValue = "2025") int year
    ) {
        return ResponseEntity.ok(calendarService.getExamEvents(year));
    }

    /**
     * 특정 날짜 일정 조회
     * GET /api/calendar/date/2025-11-21
     */
    @GetMapping("/date/{date}")
    public ResponseEntity<List<CalendarEventDto>> getSchedulesByDate(
            @PathVariable String date
    ) {
        LocalDate parsed = LocalDate.parse(date);
        return ResponseEntity.ok(calendarService.getEventsByDate(parsed));
    }

    /**
     * 특정 월 일정 조회 (옵션)
     * GET /api/calendar/month/2025/11
     */
    @GetMapping("/month/{year}/{month}")
    public ResponseEntity<List<CalendarEventDto>> getSchedulesByMonth(
            @PathVariable int year,
            @PathVariable int month
    ) {
        return ResponseEntity.ok(calendarService.getEventsByMonth(year, month));
    }
}
