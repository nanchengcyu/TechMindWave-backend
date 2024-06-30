package com.itheima.consumer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;

// @Configuration
public class DirectConfiguration {

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("hmall.direct");
    }

    @Bean
    public Queue directQueue1(){
        return new Queue("direct.queue1");
    }

    @Bean
    public Binding directQueue1BindingRed(Queue directQueue1, DirectExchange directExchange){
        return BindingBuilder.bind(directQueue1).to(directExchange).with("red");
    }

    @Bean
    public Binding directQueue1BindingBlue(Queue directQueue1, DirectExchange directExchange){
        return BindingBuilder.bind(directQueue1).to(directExchange).with("blue");
    }

    @Bean
    public Queue directQueue2(){
        return new Queue("direct.queue2");
    }

    @Bean
    public Binding directQueue2BindingRed(Queue directQueue2, DirectExchange directExchange){
        return BindingBuilder.bind(directQueue2).to(directExchange).with("red");
    }

    @Bean
    public Binding directQueue2BindingBlue(Queue directQueue2, DirectExchange directExchange){
        return BindingBuilder.bind(directQueue2).to(directExchange).with("yellow");
    }

}
