package com.zs.springcloud.controller;

import com.zs.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhouson
 * @create 2022-04-09 22:42
 */
@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderController {
    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/payment/nacos/{id}")
    public String paymentInfo(@PathVariable("id") Integer id) {
        return paymentService.getPayment(id);
    }

    @GetMapping("/payment/config/info")
    public String getConfigInfo() {
        return paymentService.getConfigInfo();
    }
}
