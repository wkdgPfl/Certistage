package com.example.certistage.chat.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatResponse {
    private String answer; // AI의 답변 내용
}
