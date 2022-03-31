package com.zs.springcloud.service;

import com.zs.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author zhouson
 * @create 2022-03-26 16:56
 */
public interface PaymentService {
    public int add(Payment payment);

    public Payment getPaymentById(@Param("id") long id);
}
