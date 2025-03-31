package com.study.spring_ai.application.service;

import com.study.spring_ai.application.dto.SortDeliveryAddressRequest;
import com.study.spring_ai.infastructure.dto.SequencedDeliveryAddress;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SortDeliveryAddressFacade {
    private final SortDeliveryAddressService sortDeliveryAddressService;

    public List<SequencedDeliveryAddress> sortDeliveryAddress(SortDeliveryAddressRequest request) {
        return sortDeliveryAddressService.sortDeliveryAddress(
                request.hubAddress(),
                DeliveryAddressFormatter.format(request.deliveryAddresses())
        );
    }
}
