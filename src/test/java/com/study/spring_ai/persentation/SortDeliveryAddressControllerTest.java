package com.study.spring_ai.persentation;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.spring_ai.application.dto.DeliveryAddress;
import com.study.spring_ai.application.dto.SortDeliveryAddressRequest;
import com.study.spring_ai.infastructure.dto.SequencedDeliveryAddress;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SortDeliveryAddressControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("기준 허브주소와 배송지 목록을 입력받아 chatGpt를 통해 응답을반환하는 테스트")
    void sortDeliveryAddress() throws Exception {
        //given
        SortDeliveryAddressRequest sortDeliveryAddressRequest = createSortDeliveryAddressRequest();

        //when
        ResultActions resultActions = this.mockMvc.perform(post("/api/chat/delivery-address/sort")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(sortDeliveryAddressRequest))
        );

        //then
        assertResult(resultActions);
        resultActions.andDo(print())
                .andExpect(status().isOk());
    }

    private void assertResult(ResultActions resultActions) throws Exception {
        List<SequencedDeliveryAddress> actual = extractBody(resultActions);

        assertThat(actual).containsExactly(
                new SequencedDeliveryAddress("부산 중구 자갈치로 42", 1),
                new SequencedDeliveryAddress("부산 중구 중구로47번길 7", 2),
                new SequencedDeliveryAddress("부산 서구 해돋이로 250", 3),
                new SequencedDeliveryAddress("부산 서구 천마로 224-2", 4),
                new SequencedDeliveryAddress("부산 서구 아미동2가 81-68", 5)
        );
    }

    private List<SequencedDeliveryAddress> extractBody(ResultActions resultActions) throws Exception {
        return objectMapper.readValue(
                resultActions.andReturn().getResponse().getContentAsString(),
                new TypeReference<>() {
                }
        );
    }

    private SortDeliveryAddressRequest createSortDeliveryAddressRequest() {
        return new SortDeliveryAddressRequest(
                "부산광역시 동구 중앙대로 206",
                createSortDeliveryAddressRequests()
        );
    }

    private List<DeliveryAddress> createSortDeliveryAddressRequests() {
        return List.of(
                new DeliveryAddress("부산 서구 해돋이로 250"),
                new DeliveryAddress("부산 서구 천마로 224-2"),
                new DeliveryAddress("부산 중구 중구로47번길 7"),
                new DeliveryAddress("부산 서구 아미동2가 81-68"),
                new DeliveryAddress("부산 중구 자갈치로 42")
        );
    }
}