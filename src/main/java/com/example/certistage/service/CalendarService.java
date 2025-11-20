package com.example.certistage.service;

import com.example.certistage.entity.ExamSchedule;
import com.example.certistage.repository.ExamScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CalendarService {

    private final ExamScheduleRepository repository;

    public List<ExamSchedule> getExamsByDate(LocalDate date) {
        return repository.findByExamDate(date);
    }
}
