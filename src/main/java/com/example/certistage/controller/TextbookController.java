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
                new TextbookDto(3L, "정보처리기사 실기 한권으로 끝내기", 25000),
                new TextbookDto(4L, "정보처리기사 시나공", 27900),
                new TextbookDto(5L, "에듀윌 데이터분석 준전문가 ADsP", 21600),
                new TextbookDto(6L, "에듀윌 산업안전기사 필기 한권끝장", 21600)

        );
    }
}