package com.study.spring_ai.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatClientConfig {

    // ai 모델과 통신하기위한 api라고 한다.
    // 해당 bulider추가 코드를 중복적으로 작성하지않기위해 빈으로 등록해서 진행하는것 같다.
    // ChatClient.Builder로 빌드를한 뒤에 추가를 진행할 수 있는것 같다.?
    @Bean
    public ChatClient chatClient(ChatClient.Builder chatClientBuilder) {
    return chatClientBuilder.build();
    }

}
