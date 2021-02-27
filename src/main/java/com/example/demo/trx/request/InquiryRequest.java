package com.example.demo.trx.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InquiryRequest {
    @NotBlank
    private String inquiryCode;
    @NotBlank
    private String productName;
    @NotNull
    private Integer amount;
}
