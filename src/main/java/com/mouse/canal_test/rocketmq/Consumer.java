package com.mouse.canal_test.rocketmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executors;

/**
 * @author gongchangyou
 * @version 1.0
 * @date 2022/1/26 5:00 下午
 */
@Slf4j
@Service
public class Consumer implements CommandLineRunner {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private StreamBridge messageChannel;

    /**
     * Callback used to run the bean.
     *
     * @param args incoming main method arguments
     * @throws Exception on error
     */
    @Override
    public void run(String... args) throws Exception {
        log.info("run");
        Executors.newFixedThreadPool(1).submit(()-> {
//        while(true) { //这里我也不知道为啥需要死循环，试过如果rocketMQ server挂掉，重启依然可以正常消费呀
            messageSource.input1().subscribe(msg -> {
                //这里如果抛异常的话，broker中的offset不会往前移，所以依然会pull到出错的那个消息,相当于 ack false了
                log.info("payload=" + new String((byte[]) msg.getPayload()));

            });
//        }
        });
    }
}
