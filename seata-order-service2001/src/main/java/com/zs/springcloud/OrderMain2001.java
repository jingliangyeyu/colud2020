package com.zs.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zhouson
 * @create 2022-04-12 13:11
 */
@SpringBootApplication
@EnableFeignClients
@MapperScan("com.zs.springcloud.dao")
public class OrderMain2001 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain2001.class, args);
    }
}
