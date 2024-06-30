package com.itheima.consumer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: FanoutConfiguration
 * Package: com.itheima.consumer.config
 * Description:
 *
 * @Author 南城余
 * @Create 2024/7/1 0:24
 * @Version 1.0
 */

public class FanoutConfiguration {
    //创建队列 构造器
    @Bean
    public Queue fanoutQueue() {
        return new Queue("fanout.queue", true);
    }

    //创建交换机
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanout.exchange");
    }

    //绑定队列和交换机
    @Bean
    public Binding fanoutBinging(Queue fanoutQueue,FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueue).to(fanoutExchange);
    }
}
