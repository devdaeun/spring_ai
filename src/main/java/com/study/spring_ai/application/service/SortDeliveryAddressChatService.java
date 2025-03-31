package com.study.spring_ai.application.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SortDeliveryAddressChatService {
    //기준 허브 주소와 정렬이 필요한 배송지 목록 전달받기

    public List<?> sortDeliveryAddressChat(String hubAddress, String formattedAddress);
}
