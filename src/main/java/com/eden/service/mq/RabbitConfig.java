package com.eden.service.mq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author chenqw
 * @date 2018/10/31
 */
@Configuration
@PropertySource("/properties/mq.properties")
public class RabbitConfig {

    @Value("${topic.queue}")
    private String queue;

    @Value("${topic.exchange}")
    private String exchange;

    @Value("${topic.binding}")
    private String binding;

    // 创建队列
    @Bean
    public Queue queueMessage() {
        return new Queue(queue);
    }

    // 创建交换器
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(exchange);
    }

    // 将队列与路由键绑定到路由器中
    @Bean
    public Binding bindingExchangeMessage() {
        return BindingBuilder.bind(queueMessage()).to(exchange()).with(binding);
    }
}
