package com.example.certistage.controller;

import com.example.certistage.dto.TextbookDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class TextbookController {

    @GetMapping("/textbooks")
    public List<TextbookDto> getTextbooks(@RequestParam(required = false) Long certificateId) {
        // TODO: 나중에 서비스에서 DB 조회하도록 변경

        // 임시 더미 데이터
        return List.of(
                new TextbookDto(3L, "에듀윌 ADsP 책", 25000),
                new TextbookDto(4L, "ADsP 합격을 위한 완벽 요약집", 27900),
                new TextbookDto(5L, "이기적 SQLD 책 교재 2026", 21600),
                new TextbookDto(6L, "내일은 SQL 개발자 SQLD 책 교재 시험합격", 21600)

        );
    }
}