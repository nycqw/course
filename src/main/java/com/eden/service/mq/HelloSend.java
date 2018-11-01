package com.eden.service.mq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 生产者
 * @author chenqw
 * @date 2018/10/31
 */
@Component
public class HelloSend {

    @Value("${topic.exchange}")
    private String exchange;

    @Value("${topic.binding}")
    private String binding;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send() {
        String sendMsg = "hello " + new Date();
        this.rabbitTemplate.convertAndSend(exchange, binding, sendMsg);
    }
}
