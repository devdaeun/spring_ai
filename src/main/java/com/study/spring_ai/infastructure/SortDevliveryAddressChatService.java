package com.study.spring_ai.infastructure;

import com.study.spring_ai.application.service.SortDeliveryAddressService;
import com.study.spring_ai.infastructure.dto.SequencedDeliveryAddress;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.study.spring_ai.infastructure.SortDeliveryPromptTemplate.promptTemplate;
@Component
@RequiredArgsConstructor
public class SortDevliveryAddressChatService implements SortDeliveryAddressService {

    private final ChatClient chatClient;

    @Override
    public List<SequencedDeliveryAddress> sortDeliveryAddress(String hubAddress, String formattedAddresses) {
        return chatClient.prompt()
                .user(userSpec->userSpec.text(promptTemplate)
                        .param("hub_address", hubAddress)
                        .param("request_addresses",formattedAddresses)
                )
                .call()
                .entity(new ParameterizedTypeReference<>(){
                });
    }
}
