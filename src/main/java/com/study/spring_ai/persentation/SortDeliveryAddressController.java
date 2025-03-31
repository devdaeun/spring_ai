package com.study.spring_ai.persentation;

import com.study.spring_ai.application.dto.DeliveryAddress;
import com.study.spring_ai.application.dto.SortDeliveryAddressRequest;
import com.study.spring_ai.application.service.SortDeliveryAddressFacade;
import com.study.spring_ai.infastructure.dto.SequencedDeliveryAddress;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SortDeliveryAddressController {

    private final SortDeliveryAddressFacade sortDeliveryAddressFacade;

    @PostMapping("/api/chat/delivery-address/sort")
    public ResponseEntity<List<SequencedDeliveryAddress>> sortDeliveryAddress(@RequestBody SortDeliveryAddressRequest request) {
        return ResponseEntity.ok(sortDeliveryAddressFacade.sortDeliveryAddress(request));
    }

}
