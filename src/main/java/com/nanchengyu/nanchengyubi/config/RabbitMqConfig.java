package com.nanchengyu.nanchengyubi.config;

import com.nanchengyu.nanchengyubi.constant.BiMqConstant;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.nanchengyu.nanchengyubi.constant.BiMqConstant.*;

/**
 * @author nanchengyu
 */
@Configuration
public class RabbitMqConfig {


    @Bean
    public MessageConverter jacksonMessageConvertor(){
        return new Jackson2JsonMessageConverter();
    }

    /**
     * 将队列和交换机声明
     */
    @Bean
    Queue TxtQueue() {
        return QueueBuilder.durable(BiMqConstant.TEXT_QUEUE_NAME)
                .withArgument("x-message-ttl", 60000)
                .withArgument("x-dead-letter-exchange", BiMqConstant.TEXT_DEAD_EXCHANGE_NAME)
                .withArgument("x-dead-letter-routing-key", BiMqConstant.TEXT_DEAD_ROUTING_KEY)
                .build();
    }


    @Bean
    public Declarables TxtDeadLetterSchema() {
        return new Declarables(
                new Queue(BiMqConstant.TEXT_DEAD_QUEUE_NAME, true),
                new DirectExchange(BiMqConstant.TEXT_DEAD_EXCHANGE_NAME),
                new DirectExchange(BiMqConstant.TEXT_EXCHANGE_NAME),
                new Binding(BiMqConstant.TEXT_DEAD_QUEUE_NAME, Binding.DestinationType.QUEUE, BiMqConstant.TEXT_DEAD_EXCHANGE_NAME, BiMqConstant.TEXT_DEAD_ROUTING_KEY, null),
                new Binding(BiMqConstant.TEXT_QUEUE_NAME, Binding.DestinationType.QUEUE, BiMqConstant.TEXT_EXCHANGE_NAME, BiMqConstant.TEXT_ROUTING_KEY, null)
        );
    }

    @Bean
    public Queue createNormalQueue() {

        return QueueBuilder.durable(BI_QUEUE)
                .withArgument("x-dead-letter-exchange", BI_DLX_EXCHANGE_NAME)
                .withArgument("x-dead-letter-routing-key", BI_DLX_ROUTING_KEY)
                .build();
    }

    @Bean
    public Declarables createBIDeadLetterSchema() {
        return new Declarables(
                new Queue(BI_DLX_QUEUE_NAME, true),
                new DirectExchange(BI_DLX_EXCHANGE_NAME),
                new DirectExchange(BI_EXCHANGE_NAME),
                new Binding(BI_QUEUE, Binding.DestinationType.QUEUE, BI_EXCHANGE_NAME, BI_ROUTING_KEY, null),
                new Binding(BI_DLX_QUEUE_NAME, Binding.DestinationType.QUEUE, BI_DLX_EXCHANGE_NAME, BI_DLX_ROUTING_KEY, null)
        );
    }

    @Bean
    public Declarables createAIQuestionSchema() {
        return new Declarables(
                new Queue(AI_DLX_QUEUE_NAME, true),
                new DirectExchange(AI_QUESTION_EXCHANGE_NAME),
                new DirectExchange(AI_DLX_EXCHANGE_NAME),
                new Binding(AI_QUESTION_QUEUE, Binding.DestinationType.QUEUE, AI_QUESTION_EXCHANGE_NAME, AI_QUESTION_ROUTING_KEY, null),
                new Binding(AI_DLX_QUEUE_NAME, Binding.DestinationType.QUEUE, AI_DLX_EXCHANGE_NAME, AI_DLX_ROUTING_KEY, null)
        );
    }

    @Bean
    public Queue createAIQuestionQueue() {
        return QueueBuilder.durable(AI_QUESTION_QUEUE)
                .withArgument("x-dead-letter-exchange", AI_DLX_EXCHANGE_NAME)
                .withArgument("x-dead-letter-routing-key", AI_DLX_ROUTING_KEY)
                .build();
    }

}
