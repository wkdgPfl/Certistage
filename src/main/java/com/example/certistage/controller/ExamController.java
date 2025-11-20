package com.example.certistage.controller;

import com.example.certistage.service.external.QnetClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/exams")
public class ExamController {

    private final QnetClient qnetClient;

    @GetMapping
    public ResponseEntity<String> getExams(
            @RequestParam(name = "year", defaultValue = "2025") int year
    ) {
        String response = qnetClient.getExamSchedule(year);
        return ResponseEntity.ok(response);
    }
}
