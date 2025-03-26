package com.study.spring_ai.persentation;

import com.study.spring_ai.application.service.BasicChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BasicChatController {

    private final BasicChatService basicChatService;

    @GetMapping("/api/chat/basic")
    public ResponseEntity<ChatResponse> basicChat(@RequestParam String prompt) {

        return ResponseEntity.ok(basicChatService.sendMessage(prompt));
    }
}
