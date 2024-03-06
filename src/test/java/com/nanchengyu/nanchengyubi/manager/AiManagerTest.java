package com.nanchengyu.nanchengyubi.manager;

import com.nanchengyu.nanchengyubi.constant.TextConstant;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author nanchengyu
 * CreateTime 2023/5/21 10:48
 */
@SpringBootTest
@Slf4j
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

    @Resource
    private ThreadPoolExecutor threadPoolExecutor;

    @Test
    void asyncProcessChartData() throws InterruptedException {
        String goal = "分析一下用户趋势";
        String chartType = "折线图";
        String cvsData = "用户,数量\n12,10\n13,12\n14,12";
        CompletableFuture.runAsync(() -> {
            // 发送给 AI 分析数据
            String promote = AiManager.PRECONDITION + "分析需求 " + goal + " \n原始数据如下: " + cvsData + "\n生成图标的类型是: " + chartType;
            System.out.println("111111");
            String resultData = null;
            try {
                resultData = aiManager.sendMesToAIUseXingHuo(promote);
            } catch (Exception e) {
                log.error(e.getMessage());
            }
            System.out.println("response:"+resultData);
            log.info("response{}", resultData);
        }, threadPoolExecutor);
        Thread.sleep(1000000);
    }
}


