package com.zs.springcloud.controller;

import com.zs.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhouson
 * @create 2022-04-10 21:02
 */
@RestController
@Slf4j
public class CircleBreakerController {
    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/consumer/testD/{id}")
    public String paymentSQL(@PathVariable("id") int id) throws InterruptedException {
        if (id % 2 != 0) {
            Thread.sleep(300);
        }
        return paymentService.testD(id);
    }
}
