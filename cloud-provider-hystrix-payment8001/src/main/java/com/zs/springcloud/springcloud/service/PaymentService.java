package com.zs.springcloud.springcloud.service;


/**
 * @author zhouson
 * @create 2022-03-26 16:56
 */
public interface PaymentService {
    String paymentInfo_OK(Integer id);

    String paymentInfo_TimeOut(Integer id);

    public String paymentCircuitBreaker(Integer id);
}
