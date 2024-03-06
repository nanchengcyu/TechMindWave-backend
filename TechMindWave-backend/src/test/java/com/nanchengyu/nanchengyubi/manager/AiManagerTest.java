package com.nanchengyu.nanchengyubi.manager;

import com.nanchengyu.nanchengyubi.constant.TextConstant;
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
        String doChat = aiManager.doChat( "分析需求：\n" +
                "分析网站用户的增长情况\n" +
                "原始数据：\n" +
                "日期，用户数\n" +
                "1号，10\n" +
                "2号，20\n" +
                "3号，30", TextConstant.MODE_ID);
        System.out.println(doChat);
    }
}