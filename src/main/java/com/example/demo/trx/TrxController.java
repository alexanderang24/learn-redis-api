package com.example.demo.trx;

import com.example.demo.trx.request.InquiryRequest;
import com.example.demo.trx.request.PaymentRequest;
import com.example.demo.trx.response.InquiryResponse;
import com.example.demo.trx.response.PaymentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class TrxController {

    @Autowired
    TrxService service;

    @PostMapping("/inquiry")
    public InquiryResponse inquiry(@RequestBody @Valid InquiryRequest request) {
        return service.inquiry(request);
    }

    @PostMapping("/payment")
    public PaymentResponse payment(@RequestBody @Valid PaymentRequest request) {
        return service.payment(request);
    }

}
