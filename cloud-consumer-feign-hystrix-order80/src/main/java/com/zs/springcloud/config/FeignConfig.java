package com.zs.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhouson
 * @create 2022-04-02 13:49
 */
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignClientConfig() {
        return Logger.Level.BASIC;
    }
}
