package com.study.spring_ai.persentation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class BasicChatControllerTest {
    //통합 테스트 코드 작성
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("chatGPT와 통신하여 답변을 조회하는 테스트입니다.")
    void basicChat() throws Exception {
        String prompt ="객체지향 원칙에 대해 설명해줘";

        ResultActions resultActions = mockMvc.perform(get("/api/chat/basic")
                .param("prompt", prompt));

        resultActions.andDo(print())
                .andExpect(status().isOk());
        
    }
}