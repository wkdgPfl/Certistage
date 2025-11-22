package com.example.certistage.chat.service;

import com.example.certistage.chat.dto.ChatMessageDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AiService {

    private final ChatClient chatClient;
    private final ChatMemory chatMemory;

    public AiService(
            ChatMemory chatMemory,
            ChatClient.Builder chatClientBuilder) {
        this.chatMemory = chatMemory;
        this.chatClient = chatClientBuilder
                .defaultAdvisors(
                        MessageChatMemoryAdvisor.builder(chatMemory).build(),
        //              PromptChatMemoryAdvisor.builder(chatMemory).build(),
                        new SimpleLoggerAdvisor(Ordered.LOWEST_PRECEDENCE-1)
                )
                .build();
    }

    public String chat(String question, String conversationId) {

        log.info(" 서비스 진입 | ID: {} | 질문: {}", conversationId, question);

        String currentDate = LocalDate.now().toString();

        String answer = chatClient.prompt()
                .system(String.format("""
    당신은 대한민국 국가기술자격 및 전문자격증 시험 일정과 정보를 안내하는 AI 비서 '자격증 마스터'입니다.
    
    [중요]
    - **오늘 날짜는 %s 입니다.** - 사용자가 '올해'나 '이번 달'을 언급하면 위 날짜를 기준으로 2025년 일정을 안내해야 합니다.
    - 공식 사이트를 참고해서 그 날짜를 파악하기 어렵다면 인터넷에 올라온 게시글 중 신뢰도가 높은 글을 참고하여 최대한 정확하게 답변해주세요.
    - 만약 당신의 학습 데이터에 2025년 최신 데이터가 없다면, "2025년 정확한 확정 공고는 큐넷이나 공식 사이트 확인이 필요합니다"라고 솔직하게 덧붙이세요.
    
    다음 지침을 엄격히 준수하여 답변하세요:
    1. **역할**: 사용자의 합격을 돕기 위해 정확한 시험 일정, 응시 자격, 시험 과목, 합격 기준을 안내합니다.
    2. **답변 형식**: 일정을 안내할 때는 가독성을 위해 반드시 불렛 포인트나 표 형식을 사용하세요.
       - 예시: [시험명] / [접수 기간] / [시험일] / [합격자 발표일]
    3. **정확성**: 거짓된 정보를 지어내지 마세요(Hallucination 방지).
    4. **톤앤매너**: 전문적이고 정중하며 격려하는 어조를 유지하세요.
    """, currentDate))
                .user(question)
                .options(ChatOptions.builder()
                        .model("gpt-4o-mini")
                        .temperature(0.3)
                        .build()
                )
                .advisors(advisorSpec -> advisorSpec
                        // "chat_memory_conversation_id": 대화방 ID
                        .param("chat_memory_conversation_id", conversationId)
                        // 최근 10개만 히스토리함
                        .param("chat_memory_retrieve_size", 10)
                )
//                .advisors(advisorSpec -> advisorSpec.param(
//                 ChatMemory.CONVERSATION_ID, conversationId
//                )
//                )
                .call()
                .content();

        return answer;
    }

    public List<ChatMessageDto> getChatHistory(String conversationId) {
        List<Message> messages = chatMemory.get(conversationId);

        // 10개 변수 추가
        int showCount = 10;

        return messages.stream()
                // 10개만 보여주게 계산
                .skip(Math.max(0, messages.size() - showCount))
                .map(ChatMessageDto::from)
                .collect(Collectors.toList());
    }
}
