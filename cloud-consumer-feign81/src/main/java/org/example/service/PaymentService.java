package org.example.service;

import org.example.domain.CommonResult;
import org.example.domain.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author yhw
 * @version 1.0
 **/
@Service
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentService {
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);
}
