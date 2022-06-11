package com.mouse.canal_test.rocketmq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author gongchangyou
 * @version 1.0
 * @date 2022/1/26 5:00 下午
 */
public interface MessageSource {

    /**
     * 消息管道
     * @return
     */
    @Input("input1")
    SubscribableChannel input1();

}
