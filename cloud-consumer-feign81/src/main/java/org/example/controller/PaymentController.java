package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.domain.CommonResult;
import org.example.domain.Payment;
import org.example.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yhw
 * @version 1.0
 **/
@RestController
@Slf4j
public class PaymentController {

    @Resource
    PaymentService paymentService;
    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentService.getPaymentById(id);
    }
}
