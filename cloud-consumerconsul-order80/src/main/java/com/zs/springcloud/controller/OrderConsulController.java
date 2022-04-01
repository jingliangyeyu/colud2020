package com.zs.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhouson
 * @create 2022-04-01 21:27
 */
@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderConsulController {
    private static final String INVOKE_URL = "http://consul-provider-payment";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/order/consul")
    public String payment() {
        return restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
    }
}
