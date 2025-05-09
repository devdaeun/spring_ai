package com.study.spring_ai.application.service;

import com.study.spring_ai.application.dto.DeliveryAddress;

import java.util.List;
import java.util.stream.Collectors;

import static org.apache.logging.log4j.util.Strings.EMPTY;

public class DeliveryAddressFormatter {
    private static final String PREFIX = "- ";
    private static final String DELIMITER = "\n";

    public static String format(List<DeliveryAddress>deliveryAddresses){
        return deliveryAddresses.stream()
                .map(DeliveryAddress::address)
                .collect(Collectors.joining(DELIMITER+PREFIX, PREFIX, EMPTY));
    }


}
