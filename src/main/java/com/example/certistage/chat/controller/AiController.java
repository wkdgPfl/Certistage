package com.example.certistage.chat.controller;

import com.example.certistage.chat.dto.ChatMessageDto;
import com.example.certistage.chat.dto.ChatRequest;
import com.example.certistage.chat.dto.ChatResponse;
import com.example.certistage.chat.service.AiService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
@RequiredArgsConstructor
public class AiController {

    private final AiService aiService;

    @PostMapping("/chat")
    public ResponseEntity<ChatResponse> chatModel(@RequestBody ChatRequest request,
                                                  HttpSession session,
                                                  @RequestHeader(value = "X-Session-Id", required = false) String headerSessionId) {
        log.info("요청완료");
        String conversationId = (headerSessionId != null && !headerSessionId.isEmpty())
                ? headerSessionId
                : session.getId();
        log.info("Chat 요청 ID: {}", conversationId);

        String answer = aiService.chat(request.getQuestion(), conversationId);
        log.info("============ Service 응답 완료 ============");
        return ResponseEntity.ok(new ChatResponse(answer));
    }

    @GetMapping("/chat/history")
    public ResponseEntity<List<ChatMessageDto>> getChatHistory(
            HttpSession session,
            // [추가] 여기도 똑같이 헤더를 받음
            @RequestHeader(value = "X-Session-Id", required = false) String headerSessionId
    ) {
        // 1. ID 결정 로직
        String conversationId = (headerSessionId != null && !headerSessionId.isEmpty())
                ? headerSessionId
                : session.getId();

        log.info("History 조회 ID: {}", conversationId);

        // 서비스 호출
        List<ChatMessageDto> history = aiService.getChatHistory(conversationId);
        return ResponseEntity.ok(history);
    }
}