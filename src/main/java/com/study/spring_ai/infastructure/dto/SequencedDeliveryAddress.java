package com.study.spring_ai.infastructure.dto;

public record SequencedDeliveryAddress(
        String address,
        int sequence
) {//배송지와 배송지 순서

}
