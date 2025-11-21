package com.example.certistage.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor          // 기본 생성자
@AllArgsConstructor         // 모든 필드를 받는 생성자
public class TextbookDto {

    private Long id;        // 교재 ID
    private String title;   // 책 제목
    private int price;      // 가격(원)
}
