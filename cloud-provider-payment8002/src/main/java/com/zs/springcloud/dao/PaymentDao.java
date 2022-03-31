package com.zs.springcloud.dao;

import com.zs.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author zhouson
 * @create 2022-03-26 16:38
 */
@Mapper
public interface PaymentDao {
    public int add(Payment payment);

    public Payment getPaymentById(@Param("id") long id);
}
