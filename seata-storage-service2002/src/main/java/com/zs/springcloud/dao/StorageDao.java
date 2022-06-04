package com.zs.springcloud.dao;

import org.apache.ibatis.annotations.Param;

/**
 * @author zhouson
 * @create 2022-04-12 14:06
 */

public interface StorageDao {
    //扣减库存信息
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
