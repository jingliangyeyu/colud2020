package com.zs.springcloud.controller;

import com.zs.springcloud.entities.CommonResult;
import com.zs.springcloud.entities.Payment;
import com.zs.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zhouson
 * @create 2022-03-26 16:59
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/add")
    public CommonResult<Payment> addPayment(@RequestBody Payment payment) {
        int result = paymentService.add(payment);
        if (result > 0) {
            return new CommonResult<Payment>(200, "添加账户成功" + serverPort);
        }
        return new CommonResult<Payment>(444, "添加账户失败" + serverPort);
    }

    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") int id) {
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null) {
            return new CommonResult<Payment>(200, "查询成功" + serverPort, payment);
        } else {
            return new CommonResult<Payment>(444, "没有查询到数据" + serverPort);
        }
    }

    @GetMapping("/discovery")
    public DiscoveryClient getDiscoveryClient() {
        List<String> services = discoveryClient.getServices();
        services.forEach(service -> {
            log.info("***** service:" + service);
        });
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        instances.forEach(instance -> {
            log.info("instance.serviceId:{},instance.instanceId():{},instance.host():{}, instance.port():{}",
                    instance.getServiceId(), instance.getInstanceId(), instance.getHost(), instance.getPort());
        });
        return discoveryClient;
    }

    @RequestMapping("/feign/timeout")
    public String paymentFeignTimeOut() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
