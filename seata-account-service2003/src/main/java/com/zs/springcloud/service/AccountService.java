package com.zs.springcloud.service;

import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author zhouson
 * @create 2022-04-12 14:19
 */
public interface AccountService {
    /**
     * 扣减账户余额
     */
    void decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
