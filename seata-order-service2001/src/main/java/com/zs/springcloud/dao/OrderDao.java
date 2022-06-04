package com.zs.springcloud.dao;

import com.zs.springcloud.domain.Order;
import org.apache.ibatis.annotations.Param;

/**
 * @author zhouson
 * @create 2022-04-12 13:10
 */
public interface OrderDao {
    /**
     * 新建订单
     *
     * @param order
     * @return
     */
    int create(Order order);

    /**
     * 修改订单状态，从零改为1
     *
     * @param userId
     * @param status
     */
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
