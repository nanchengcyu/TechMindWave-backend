package com.nanchengyu.nanchengyubi.constant;

/**
 * @author nanchengyu
 * CreateTime 2023/6/24 16:26
 * 应用到BI项目当中的mq常量
 */
public interface BiMqConstant {

    String BI_EXCHANGE_NAME = "bi_exchange";

    String BI_QUEUE_NAME = "bi_queue";

    String BI_ROUTING_KEY = "bi_routing_key";

    String BI_DLX_QUEUE_NAME = "bi_dlx_queue";

    String BI_DLX_ROUTING_KEY = "bi_dlx_routing_key";

    String BI_DLX_EXCHANGE_NAME = "bi_dlx_exchange";

    // 限制同时生成的图表数量
    int MAX_CONCURRENT_CHARTS = 5;

    /**
     * 普通交换机
     */

    String BI_QUEUE = "bi_queue";

    String BI_DIRECT_EXCHANGE = "direct";





    /**
     * AI 问答
     */
    String AI_QUESTION_EXCHANGE_NAME = "ai_question_exchange";

    String AI_QUESTION_QUEUE = "ai_question_queue";
    String AI_QUESTION_ROUTING_KEY = "ai_question_routingKey";


    /**
     * AI对话死信队列交换机
     */
    String AI_DLX_EXCHANGE_NAME = "ai-dlx-exchange";

    /**
     * AI对话死信队列
     */
    String AI_DLX_QUEUE_NAME = "ai_dlx_queue";

    /**
     * AI对话死信队列路由键
     */
    String AI_DLX_ROUTING_KEY = "ai_dlx_routingKey";

    /**
     * MQ ip地址
     */
    String BI_MQ_HOST = "106.14.202.122";

    /**
     * MQ 用户名
     */
    String BI_MQ_USERNAME = "nanchengyu";

    /**
     * MQ 密码
     */
    String BI_MQ_PASSWORD = "1234";

}
