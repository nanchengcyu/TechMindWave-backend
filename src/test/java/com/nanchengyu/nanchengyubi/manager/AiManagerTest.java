package com.nanchengyu.nanchengyubi.manager;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author nanchengyu
 * CreateTime 2023/5/21 10:48
 */
@SpringBootTest
class AiManagerTest {

    @Resource
    private AiManager aiManager;

    @Test
    void doChat() {

        System.out.println("test");
    }
}