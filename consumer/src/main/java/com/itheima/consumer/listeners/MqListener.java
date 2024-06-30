package com.itheima.consumer.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
public class MqListener {

    @RabbitListener(queues = "simple.queue")
    public void listenSimpleQueue(String msg){
        System.out.println("消费者收到了simple.queue的消息：【" + msg +"】");
    }

    @RabbitListener(queues = "work.queue")
    public void listenWorkQueue1(String msg){
        System.out.println("消费者1收到了work.queue的消息：【" + msg +"】");
    }
    @RabbitListener(queues = "work.queue")
    public void listenWorkQueue2(String msg){
        System.err.println("消费者2收到了work.queue的消息：【[[[[[" + msg +"】");
    }
    @RabbitListener(queues = "fanout.queue1")
    public void listenFanOutQueue1(String msg){
        System.err.println("消费者 1 收到了 fanout.queue1的消息：【[[[[[" + msg +"】");
    }

    @RabbitListener(queues = "fanout.queue2")
    public void listenFanOutQueue2(String msg){
        System.err.println("消费者 2 收到了 fanout.queue2的消息：【[[[[[" + msg +"】");
    }
}
