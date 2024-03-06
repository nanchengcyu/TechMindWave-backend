package com.nanchengyu.nanchengyubi.bizmq;

import com.google.gson.Gson;
import com.nanchengyu.nanchengyubi.constant.BiMqConstant;
import com.nanchengyu.nanchengyubi.constant.CommonConstant;
import com.nanchengyu.nanchengyubi.manager.AiManager;
import com.nanchengyu.nanchengyubi.model.entity.AiAssistant;
import com.nanchengyu.nanchengyubi.model.enums.ChartStatusEnum;
import com.nanchengyu.nanchengyubi.service.AiAssistantService;
import com.rabbitmq.client.Channel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author nanchengyu
 * CreateTime 2023/6/25 20:07
 * AI 问答 MQ 队列
 */
@Slf4j
@Component
@AllArgsConstructor
public class AiAssistantMq {

    private final static Gson GSON = new Gson();

    @Resource
    private AiManager aiManager;
    @Resource
    private AiAssistantService aiAssistantService;

    @RabbitListener(queues = BiMqConstant.AI_QUESTION_QUEUE, ackMode = "MANUAL")
    public void handle(Message message, Channel channel) throws IOException {
        AiAssistant aiAssistant = null;
        try {
            String data = new String(message.getBody());
            aiAssistant = GSON.fromJson(data, AiAssistant.class);
            String questionGoal = aiAssistant.getQuestionGoal();
            // 调用 AI
            String result = aiManager.doAiChat(CommonConstant.AI_MODEL_ID, questionGoal);
            aiAssistant.setQuestionResult(result);
            aiAssistant.setQuestionStatus(ChartStatusEnum.SUCCEED.getValue());
            aiAssistantService.updateById(aiAssistant);
            // 交付标签，消息id
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            // 拒绝后丢弃
            channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
            if (aiAssistant != null) {
                aiAssistant.setQuestionStatus(ChartStatusEnum.FAILED.getValue());
                aiAssistantService.updateById(aiAssistant);
            }
        }
    }
}
