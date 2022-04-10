package com.zs.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhouson
 * @create 2022-04-09 22:40
 */
@Component
@FeignClient(value = "nacos-payment-provider")
@RequestMapping("/payment")
public interface PaymentService {
    @GetMapping(value = "/nacos/{id}")
    String getPayment(@PathVariable("id") Integer id);

    @GetMapping("/config/info")
    String getConfigInfo();
}
