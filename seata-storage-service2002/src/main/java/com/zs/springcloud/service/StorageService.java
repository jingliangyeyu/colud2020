package com.zs.springcloud.service;

/**
 * @author zhouson
 * @create 2022-04-12 14:08
 */
public interface StorageService {

    // 扣减库存
    void decrease(Long productId, Integer count);
}
