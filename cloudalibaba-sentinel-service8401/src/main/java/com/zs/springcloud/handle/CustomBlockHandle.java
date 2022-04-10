package com.zs.springcloud.handle;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * 自定义降级处理类
 * 一定要是public static修饰方法
 *
 * @author zhouson
 * @create 2022-04-10 20:21
 */
public class CustomBlockHandle {
    public static String handleException(int id, BlockException exception) {
        return id + "*********id,自定义的限流处理信息********";
    }
}
