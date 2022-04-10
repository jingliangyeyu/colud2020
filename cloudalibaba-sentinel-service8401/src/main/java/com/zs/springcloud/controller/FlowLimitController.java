package com.zs.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zs.springcloud.handle.CustomBlockHandle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhouson
 * @create 2022-04-10 10:11
 */
@RestController
@Slf4j
@RefreshScope
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA() {
        log.info("------testA");
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB() {

        return "------testB";
    }

    @GetMapping("/testC/{id}")
    @SentinelResource(value = "testC", blockHandler = "deal_testHotKey")
    public String testC(@PathVariable("id") int id) throws InterruptedException {
        if (id % 2 == 0) {
            log.info("------testC");
            return "------testC";
        }
        Thread.sleep(1000);
        log.info("------sleep 1000ms ,testC");
        return "------sleep 1000ms ,testC";
    }

    //兜底方法
    public String deal_testHotKey(int id, BlockException exception) {
        return "------deal_testHotKey,o(╥﹏╥)o";
    }

    @GetMapping("/testD/{id}")
    @SentinelResource(value = "testD",
            blockHandlerClass = CustomBlockHandle.class,
            blockHandler = "handleException"
    )
    public String testD(@PathVariable("id") int id) throws InterruptedException {
        if (id % 2 == 0) {
            log.info("------testD");
            return "------testD";
        }
        Thread.sleep(200);
        log.info("------sleep 200ms ,testD");
        return "------sleep 200ms ,testD";
    }
}
