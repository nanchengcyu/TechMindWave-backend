package com.nanchengyu.nanchengyubi.bizmq;

import com.nanchengyu.nanchengyubi.manager.AiManager;
import com.nanchengyu.nanchengyubi.model.dto.Essay.GenEssayMessage;
import com.nanchengyu.nanchengyubi.model.entity.Essay;
import com.nanchengyu.nanchengyubi.service.EssayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


/**
 * ClassName: EssayConsumer
 * Package: com.nanchengyu.nanchengyubi.bizmq
 * Description:
 *    文章生成消费者
 * @Author 南城余
 * @Create 2024/7/1 23:15
 * @Version 1.0
 */
@Slf4j
@Component
public class EssayConsumer {
    @Autowired
    private AiManager aiManager;
    @Autowired
    private EssayService essayService;
    @RabbitListener(queues = "genEssayQueue")
    public void processGenEssayMessage(@Payload GenEssayMessage message) {
        log.info("AI生成文章名字:{}",message.getEssayName());
        // 调用 AI 发送消息 生成文章
        String genResult = aiManager.sendMesToAIUseXingHuo(AiManager.ESSAY_PRECONDITION + message.getEssayName() + "文章的类型是：" + message.getEssayType());
        //保存内容到数据库
        Essay essay = new Essay();
        essay.setUserId(message.getUserId());
        essay.setGenEssay(genResult);
        essay.setEssayName(message.getEssayName());
        essay.setEssayType(message.getEssayType());
        essayService.save(essay);
    }

}
