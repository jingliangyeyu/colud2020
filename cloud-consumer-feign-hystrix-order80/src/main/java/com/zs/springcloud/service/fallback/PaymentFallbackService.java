package com.zs.springcloud.service.fallback;

import com.zs.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

/**
 * @author zhouson
 * @create 2022-04-03 23:53
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_OK , (┬＿┬)";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_TimeOut , (┬＿┬)";
    }
}
