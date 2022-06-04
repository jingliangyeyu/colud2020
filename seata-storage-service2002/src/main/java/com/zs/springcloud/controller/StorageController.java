package com.zs.springcloud.controller;

import com.zs.springcloud.entities.CommonResult;
import com.zs.springcloud.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhouson
 * @create 2022-04-12 14:09
 */
@RestController
public class StorageController {

    @Autowired
    private StorageService storageService;

    //扣减库存
    @RequestMapping("/storage/decrease")
    public CommonResult decrease(Long productId, Integer count) {
        storageService.decrease(productId, count);
        return new CommonResult(200, "扣减库存成功！");
    }
}
