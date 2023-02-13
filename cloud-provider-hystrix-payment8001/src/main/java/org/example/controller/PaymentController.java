package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
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
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    @GetMapping(value = "/payment/hystrix/timeout/{id}")
    public String getInfo_timeOut(@PathVariable("id")Long id){
        return paymentService.info_timeOut(id);
    }
    @GetMapping(value = "/payment/hystrix/ok/{id}")
    public String getInfo_ok(@PathVariable("id")Long id){
        return paymentService.getOk(id);
    }
    @GetMapping(value = "/payment/hystrix/circuit/{id}")
    public String getInfo_circuit(@PathVariable("id")Long id){
        return paymentService.paymentCircuitBreaker(id);
    }
}
