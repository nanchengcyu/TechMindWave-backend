package com.nanchengyu.nanchengyubi.constant;

/**
 * @author nanchengyu
 * CreateTime 2023/6/24 16:26
 * 应用到BI项目当中的mq常量
 */
public interface BiMqConstant {

    /**
     * 普通交换机
     */
    String BI_EXCHANGE_NAME = "tech_bi_exchange";

    String BI_QUEUE = "tech_bi_queue";

    String BI_ROUTING_KEY = "tech_bi_routingKey";

    /**
     * 死信队列交换机
     */
    String BI_DLX_EXCHANGE_NAME = "tech_bi-dlx-exchange";

    /**
     * 死信队列
     */
    String BI_DLX_QUEUE_NAME = "tech_bi_dlx_queue";

    /**
     * 死信队列路由键
     */
    String BI_DLX_ROUTING_KEY = "tech_bi_dlx_routingKey";

    /**
     * AI 问答
     */
    String AI_QUESTION_EXCHANGE_NAME = "tech_ai_question_exchange";

    String AI_QUESTION_QUEUE = "tech_ai_question_queue";

    String AI_QUESTION_ROUTING_KEY = "tech_ai_question_routingKey";


    /**
     * AI对话死信队列交换机
     */
    String AI_DLX_EXCHANGE_NAME = "tech_ai-dlx-exchange";

    /**
     * AI对话死信队列
     */
    String AI_DLX_QUEUE_NAME = "tech_ai_dlx_queue";

    /**
     * AI对话死信队列路由键
     */
    String AI_DLX_ROUTING_KEY = "tech_ai_dlx_routingKey";

    //文本AI生成队列

    String TEXT_EXCHANGE_NAME = "tech_text_exchange";

    String TEXT_QUEUE_NAME="tech_text_queue";

    String TEXT_ROUTING_KEY="tech_text_routingKey";
    //死信
    String TEXT_DEAD_EXCHANGE_NAME="tech_text_dead_exchange";
    String TEXT_DEAD_QUEUE_NAME="tech_text_dead_queue";

    String TEXT_DEAD_ROUTING_KEY="tech_text_dead_routingKey";
}
