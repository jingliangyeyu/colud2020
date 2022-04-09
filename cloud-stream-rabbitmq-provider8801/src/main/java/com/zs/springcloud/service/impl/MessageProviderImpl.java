package com.zs.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.zs.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;

/**
 * @author zhouson
 * @create 2022-04-09 9:28
 */
@Slf4j
@EnableBinding(Source.class)
public class MessageProviderImpl implements IMessageProvider {
    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String uuid = IdUtil.randomUUID();
        boolean send = output.send(MessageBuilder.withPayload(uuid).build());
        if (send) {
            log.info("发送成功，message：{}", uuid);
            return uuid;
        }
        return null;
    }
}
