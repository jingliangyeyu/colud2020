package com.zs.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhouson
 * @create 2022-04-01 22:48
 */
@Configuration
public class MyselfRule {
    @Bean
    public IRule myRule() {
        return new RandomRule();
    }

}
