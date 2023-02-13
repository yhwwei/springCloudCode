package org.example.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.domain.Payment;

/**
 * @author yhw
 * @version 1.0
 **/
@Mapper
public interface PaymentDao {
    /**
     * 创建Payment
     * @param payment
     * @return
     */
    int create(Payment payment);


    /**
     * 通过id获取Payment
     * @param id
     * @return
     */
    Payment getPaymentById(@Param("id") Long id);
}
