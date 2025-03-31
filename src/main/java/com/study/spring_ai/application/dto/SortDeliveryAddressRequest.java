package com.study.spring_ai.application.dto;

import java.util.List;

public record SortDeliveryAddressRequest(
        String hubAddress,
        List<DeliveryAddress> deliveryAddresses
) {
}
