package com.nanchengyu.nanchengyubi.bizmq;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author nanchengyu
 * CreateTime 2023/7/3 17:40
 */
@SpringBootTest
class BiMqMessageProducerTest {

    @Resource
    private BiMqMessageProducer producer;

    @Test
    void sendMessage() {
        producer.sendMessage("进入死信队列~~~~1111");
    }
}