package com.example.certistage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CalendarEventDto {
    private String date;        // yyyyMMdd
    private String title;       // "필기시험 시작" 등
    private String examType;    // DOC / PRAC
    private String description; // 전체 설명
}
