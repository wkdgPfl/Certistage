package com.example.certistage.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExamSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String certificateName;    // 종목명
    private String category;           // 항목 (예: 필기/실기 날짜)
    @Column(columnDefinition = "TEXT")
    private String content;            // 내용

    private LocalDate examDate;        // 날짜
}
