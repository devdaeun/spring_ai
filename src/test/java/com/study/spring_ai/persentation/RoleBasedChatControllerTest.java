package com.study.spring_ai.persentation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class RoleBasedChatControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("prompt와 role을 전달하여 chatGpt의 응답을 반환하는 메소드입니다.")
    void roleBasedChat() throws Exception {
        String prompt = "IT 분야의 모니터링 시스템에대해 설명해줘";
        String role ="IT 분야 모니터링";

        ResultActions resultActions = mockMvc.perform(get("/api/chat/role")
                .param("prompt", prompt)
                .param("role", role));

        resultActions.andDo(print())
                .andExpect(status().isOk());

    }
}