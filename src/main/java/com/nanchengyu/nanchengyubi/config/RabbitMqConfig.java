package com.nanchengyu.nanchengyubi.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.nanchengyu.nanchengyubi.constant.BiMqConstant.*;

/**
 * @author nanchengyu
 */
@Configuration
public class RabbitMqConfig {
    /**
     * 问答队列
     */
    @Bean
    public Queue aiQuestionQueue() {
        return new Queue(AI_QUESTION_QUEUE, true);
    }

    /**
     * 交换机
     */
    @Bean
    DirectExchange qaDirectExchange() {
        return new DirectExchange(AI_QUESTION_EXCHANGE_NAME, true, false);
    }

    /**
     * 绑定队列和交换机
     */
    @Bean
    Binding bindingDirect() {
        return BindingBuilder.bind(aiQuestionQueue()).to(qaDirectExchange()).with(AI_QUESTION_ROUTING_KEY);
    }
}
