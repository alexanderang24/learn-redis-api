package com.example.demo.trx;

import com.example.demo.trx.request.InquiryRequest;
import com.example.demo.trx.request.PaymentRequest;
import com.example.demo.trx.response.InquiryResponse;
import com.example.demo.trx.response.PaymentResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class TrxService {

    private final RestTemplate restTemplate = new RestTemplate();

    private static final String CORE_URL = "http://localhost:8080/core/trx";

    @Cacheable(value = "inquiryResponse", key="{#request.inquiryCode, #request.productName, #request.amount}")
    public InquiryResponse inquiry(InquiryRequest request) {
        log.info("Sending payment request to core with inquiry code: " + request.getInquiryCode());
        return restTemplate.exchange(
                CORE_URL + "/inquiry",
                HttpMethod.POST, new HttpEntity<>(request),
                new ParameterizedTypeReference<InquiryResponse>(){})
            .getBody();
    }

    @Cacheable(value = "paymentResponse", key="#request.inquiryCode")
    public PaymentResponse payment(PaymentRequest request) {
        log.info("Sending payment request to core with inquiry code: " + request.getInquiryCode());
        return restTemplate.exchange(
                CORE_URL + "/payment",
                HttpMethod.POST, new HttpEntity<>(request),
                new ParameterizedTypeReference<PaymentResponse>(){})
                .getBody();
    }
}
