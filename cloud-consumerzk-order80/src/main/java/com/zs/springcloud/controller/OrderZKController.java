package com.zs.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhouson
 * @create 2022-03-31 23:54
 */
@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderZKController {
    @Autowired
    private RestTemplate restTemplate;

    private static final String INVOME_URL = "http://cloud-provider-payment";

    @GetMapping("/payment/zk")
    public String getPayment() {
        return restTemplate.getForObject(INVOME_URL + "/payment/zk", String.class);
    }
}
