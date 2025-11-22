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
    public ResponseEntity<ChatResponse> chatModel(@RequestBody ChatRequest request, HttpSession session) {
        log.info("요청완료");
        String conversationId = session.getId();
        log.info("세션 ID: {}", session.getId());

        String question = request.getQuestion();
        log.info("받은 질문: {}", question);

        String answer = aiService.chat(question, conversationId);
        log.info("============ Service 응답 완료 ============");
        ChatResponse response = new ChatResponse(answer);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/chat/history")
    public ResponseEntity<List<ChatMessageDto>> getChatHistory(HttpSession session) {
        String conversationId = session.getId();

        // 서비스에서 기록 가져오기
        List<ChatMessageDto> history = aiService.getChatHistory(conversationId);

        return ResponseEntity.ok(history);
    }
}
