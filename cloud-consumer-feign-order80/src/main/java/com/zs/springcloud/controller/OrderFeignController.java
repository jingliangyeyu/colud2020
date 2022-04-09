package com.zs.springcloud.controller;

import com.zs.springcloud.entities.CommonResult;
import com.zs.springcloud.entities.Payment;
import com.zs.springcloud.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhouson
 * @create 2022-04-02 0:33
 */
@RestController
@RequestMapping("/consumer")
public class OrderFeignController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") int id) {
        return paymentFeignService.getPaymentById(id);
    }

    @RequestMapping("/payment/feign/timeout")
    public String paymentFeignTimeOut() {
        return paymentFeignService.paymentFeignTimeOut();
    }

    @GetMapping("/payment/zipkin")
    public String paymentZipkin() {
        return paymentFeignService.paymentZipkin();
    }
}
