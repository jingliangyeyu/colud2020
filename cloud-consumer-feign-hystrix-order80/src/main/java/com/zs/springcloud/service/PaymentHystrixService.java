package com.zs.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zhouson
 * @create 2022-04-03 23:53
 */
@Component
// @FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT", fallback = PaymentFallbackService.class)
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT")
/**
 * 如果有Feign有通用的降级方法 如上面的注解fallback有值，就不应该用@RequestMapping注解 否则会报匹配异常
 * java.lang.IllegalStateException: Ambiguous mapping. Cannot map 'com.zs.springcloud.service.PaymentHystrixService' method
 * com.zs.springcloud.service.PaymentHystrixService#paymentInfo_OK(Integer)
 * to {GET /payment/hystrix/ok/{id}}: There is already 'paymentFallbackService' bean method
 */

// @RequestMapping("/payment")
public interface PaymentHystrixService {
    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id);
}
