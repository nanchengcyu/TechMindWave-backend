package com.nanchengyu.nanchengyubi.bizmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: EssayMQConfig
 * Package: com.nanchengyu.nanchengyubi.bizmq
 * Description:
 *  声明创建文章队列、交换机等
 * @Author 南城余
 * @Create 2024/7/1 23:05
 * @Version 1.0
 */
@Configuration
public class EssayMQConfig {
    @Bean
    public Queue genEssayQueue(){
        return new Queue("genEssayQueue");
    }
    @Bean
    public DirectExchange genEssayExchange(){
        return new DirectExchange("genEssayExchange");
    }
    //绑定队列和交换机
    @Bean
    public Binding genEssayBinding(Queue genEssayQueue,DirectExchange genEssayExchange){
        return BindingBuilder.bind(genEssayQueue).to(genEssayExchange).with("genEssayRoutingKey");
    }
    @Bean
    public SimpleRabbitListenerContainerFactory myFactory(ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setConcurrentConsumers(3);
        factory.setMaxConcurrentConsumers(10);
        return factory;
    }
}
