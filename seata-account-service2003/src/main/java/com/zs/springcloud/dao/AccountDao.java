package com.zs.springcloud.dao;

import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author zhouson
 * @create 2022-04-12 14:18
 */
public interface AccountDao {

    /**
     * 扣减账户余额
     */
    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
