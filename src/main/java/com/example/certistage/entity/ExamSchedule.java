package com.example.certistage.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "exam_schedule")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExamSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String category;

    @Column(name = "certificate_name")
    private String certificateName;

    private String content;

    @Column(name = "exam_date")
    private LocalDate examDate;

    @Column(name = "exam_start_date")
    private LocalDate examStartDate;

    @Column(name = "exam_end_date")
    private LocalDate examEndDate;
}
