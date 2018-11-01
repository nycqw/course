package com.eden.service.mq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消费者
 *
 * @author chenqw
 * @date 2018/10/31
 */
@Component
public class HelloReceiver {

    @RabbitListener(queues = "topic.message")
    public void helloReceiver(String str) {
        System.out.println("message:" + str);
    }
}


