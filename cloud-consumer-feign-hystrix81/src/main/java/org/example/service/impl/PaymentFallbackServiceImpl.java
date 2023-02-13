package org.example.service.impl;

import org.example.service.PaymentHystrixService;
import org.springframework.stereotype.Service;

/**
 * @author yhw
 * @version 1.0
 **/
@Service
public class PaymentFallbackServiceImpl implements PaymentHystrixService {

    @Override
    public String paymentInfoOK(Long id) {
        return "-----PaymentFallbackService fall back-paymentInfo_OK ,o(╥﹏╥)o";
    }

    @Override
    public String paymentInfoTimeOut(Long id) {
        return "-----PaymentFallbackService fall back-paymentInfo_TimeOut ,o(╥﹏╥)o";
    }

}
