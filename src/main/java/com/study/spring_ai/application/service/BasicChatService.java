package com.study.spring_ai.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BasicChatService {

    private final ChatClient chatClient;

    //prompt를 chatclient를 통해 전달해보기
    //사용자의 질문 : String prompt
    public ChatResponse sendMessage(String prompt){
        ChatResponse response
                = chatClient.prompt() //사용자 시스템 및 프롬프트의 다른부분을 빌드할 수 있다.
                .user(prompt)
                .call()
                .chatResponse();//답변을 반환하도록 구현

        return response; //메타데이터를 포함하여 응답을 반환하도록 진행.
    }
}
