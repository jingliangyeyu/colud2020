package com.zs.springcloud;

import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;

/**
 * @author zhouson
 * @create 2022-04-05 15:44
 */
public class MyTest {
    @Test
    public void test() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);
    }
}
