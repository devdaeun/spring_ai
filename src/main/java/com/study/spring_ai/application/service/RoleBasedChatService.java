package com.study.spring_ai.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleBasedChatService {

    private final ChatClient roleBasedChatClient;

    public String roleBasedChat(String role, String prompt) {
        return roleBasedChatClient.prompt()
                .system(promptSystemSpec ->
                        promptSystemSpec.param("role", role))
                .user(prompt)
                .call()
                .content();//응답 문자열 변환
    }
}


