package com.example.certistage.controller;

import com.example.certistage.entity.ExamSchedule;
import com.example.certistage.service.CalendarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/calendar")
@RequiredArgsConstructor
public class CalendarController {

    private final CalendarService calendarService;

    @GetMapping("/exams/{date}")
    public List<ExamSchedule> getExams(@PathVariable String date) {
        return calendarService.getExamsByDate(LocalDate.parse(date));
    }
}
