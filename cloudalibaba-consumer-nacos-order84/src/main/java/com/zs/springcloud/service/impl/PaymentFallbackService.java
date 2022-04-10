package com.zs.springcloud.service.impl;

import com.zs.springcloud.service.PaymentService;
import org.springframework.stereotype.Component;

/**
 * 自定义feign降级处理类
 * 注意不管是sentinel自身熔断的处理还是feign自身超时都会调用这个方法,不包括代码错误
 *
 * @author zhouson
 * @create 2022-04-10 21:04
 */
@Component
public class PaymentFallbackService implements PaymentService {

    @Override
    public String testD(int id) {
        return "feign降级方法";
    }
}
