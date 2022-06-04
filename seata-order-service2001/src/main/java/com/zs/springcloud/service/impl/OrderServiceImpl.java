package com.zs.springcloud.service.impl;

import com.zs.springcloud.dao.OrderDao;
import com.zs.springcloud.domain.Order;
import com.zs.springcloud.service.AccountService;
import com.zs.springcloud.service.OrderService;
import com.zs.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhouson
 * @create 2022-04-12 14:00
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Autowired
    private AccountService accountService;

    @Autowired
    private StorageService storageService;

    @Autowired
    private OrderDao orderDao;

    @Override
    @GlobalTransactional(name = "order_transaction", rollbackFor = Exception.class)
    public int create(Order order) {
        log.info("===============create order start===============");
        int i = orderDao.create(order);
        log.info("===============storage decrease start===============");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("===============storage decrease end===============");
        log.info("===============account money decrease start===============");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("===============account money decrease end===============");
        log.info("===============create order end===============");
        return i;
    }
}
