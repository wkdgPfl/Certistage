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
                new TextbookDto(1L, "정보처리기사 한 권으로 끝내기", 18000),
                new TextbookDto(2L, "정보처리기사 기출문제집", 15000)
        );
    }
}
