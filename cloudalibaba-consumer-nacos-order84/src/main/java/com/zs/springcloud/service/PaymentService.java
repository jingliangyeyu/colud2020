package com.zs.springcloud.service;

import com.zs.springcloud.service.impl.PaymentFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zhouson
 * @create 2022-04-10 21:03
 */
@FeignClient(value = "cloudalibaba-sentinel-service", fallback = PaymentFallbackService.class)
public interface PaymentService {
    @GetMapping("/testD/{id}")
    public String testD(@PathVariable("id") int id);
}
