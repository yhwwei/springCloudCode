package org.example.service;

import org.example.domain.Payment;

/**
 * @author yhw
 * @version 1.0
 **/
public interface PaymentService {
    /**
     * 插入
     * @param payment
     * @return
     */
    public int create(Payment payment);

    /**
     * 查询
     * @param id
     * @return
     */
    public Payment getPaymentById(Long id);
}
