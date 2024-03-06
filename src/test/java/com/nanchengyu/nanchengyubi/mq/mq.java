package com.nanchengyu.nanchengyubi.mq;

import com.nanchengyu.nanchengyubi.bizmq.BiMqMessageProducer;
import com.nanchengyu.nanchengyubi.constant.BiMqConstant;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;

/**
 * ClassName: mq
 * Package: com.nanchengyu.nanchengyubi.mq
 * Description:
 *
 * @Author 南城余
 * @Create 2024/3/5 20:22
 * @Version 1.0
 */
@SpringBootTest
public class mq {
    @Resource
    private BiMqMessageProducer biMqMessageProducer;

    @Test
    void test() {
        biMqMessageProducer.sendMessage(BiMqConstant.BI_EXCHANGE_NAME, BiMqConstant.BI_ROUTING_KEY, "123");
    }

}
