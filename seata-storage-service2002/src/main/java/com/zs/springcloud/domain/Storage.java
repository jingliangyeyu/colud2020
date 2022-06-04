package com.zs.springcloud.domain;

import lombok.Data;

/**
 * @author zhouson
 * @create 2022-04-12 14:06
 */
@Data
public class Storage {

    private Long id;

    // 产品id
    private Long productId;

    //总库存
    private Integer total;


    //已用库存
    private Integer used;


    //剩余库存
    private Integer residue;
}

