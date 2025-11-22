package com.example.certistage.chat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.ai.chat.messages.Message;

@Data
@AllArgsConstructor
public class ChatMessageDto {
    private String role;    // "user" 또는 "assistant"
    private String content; // 대화 내용

    public static ChatMessageDto from(Message message) {
        return new ChatMessageDto(
                message.getMessageType().getValue(), // role 변환
                message.getText()     // content 꺼내기
        );
    }
}
