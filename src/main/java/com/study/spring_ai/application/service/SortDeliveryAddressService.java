package com.study.spring_ai.application.service;

import com.study.spring_ai.infastructure.dto.SequencedDeliveryAddress;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SortDeliveryAddressService {
    //기준 허브 주소와 정렬이 필요한 배송지 목록 전달받기

    List<SequencedDeliveryAddress> sortDeliveryAddress(String hubAddress, String formattedAddresses);

}
