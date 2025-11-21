package com.example.certistage.repository;

import com.example.certistage.entity.ExamSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ExamScheduleRepository extends JpaRepository<ExamSchedule, Long> {

    // 단일 날짜 시험
    List<ExamSchedule> findByExamDate(LocalDate date);

    // 기간형 시험: 시작 ≤ date ≤ 끝
    List<ExamSchedule> findByExamStartDateLessThanEqualAndExamEndDateGreaterThanEqual(
            LocalDate date1, LocalDate date2
    );
}
