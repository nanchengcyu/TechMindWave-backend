package com.nanchengyu.nanchengyubi.manager;

import com.nanchengyu.nanchengyubi.common.ErrorCode;
import com.nanchengyu.nanchengyubi.config.AiModelConfig;
import com.nanchengyu.nanchengyubi.exception.BusinessException;
import com.yupi.yucongming.dev.client.YuCongMingClient;
import com.yupi.yucongming.dev.common.BaseResponse;
import com.yupi.yucongming.dev.model.DevChatRequest;
import com.yupi.yucongming.dev.model.DevChatResponse;
import io.github.briqt.spark4j.SparkClient;
import io.github.briqt.spark4j.constant.SparkApiVersion;
import io.github.briqt.spark4j.model.SparkMessage;
import io.github.briqt.spark4j.model.SparkSyncChatResponse;
import io.github.briqt.spark4j.model.request.SparkRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author nanchengyu
 * CreateTime 2023/5/21 10:42
 */
@Slf4j
@Service
public class AiManager {

    @Resource
    private YuCongMingClient congMingClient;

    @Resource
    private AiModelConfig aiModelConfig;

    @Resource
    private SparkClient sparkClient;
    /**
     * AI 生成问题的预设条件
     */

    public static final String PRECONDITION = "你是一个数据分析师和前端开发专家，接下来我会按照以下固定格式给你提供内容：\n" +
            "分析需求：\n" +
            "{数据分析的需求或者目标}\n" +
            "原始数据：\n" +
            "{csv格式的原始数据，用,作为分隔符}\n" +
            "请根据这两部分内容，严格按照以下指定格式生成内容（此外不要输出任何多余的开头、结尾、注释）同时不要使用这个符号 '】'\n" +
            "'【【【【【'\n" +
            "{前端 Echarts V5 的 option 配置对象 JSON 代码, 不要生成任何多余的内容，比如注释和代码块标记}\n" +
            "'【【【【【'\n" +
            "{明确的数据分析结论、越详细越好，不要生成多余的注释} \n"
            + "下面是一个具体的例子的模板："
            + "'【【【【【'\n"
            + "{\"xxx\": }"
            + "'【【【【【'\n" +
            "结论：";

//    public static final String PRECONDITION = "你是一个数据分析师和前端开发专家，接下来我会按照以下固定格式给你提供内容：\n" +
//            "分析需求：\n" +
//            "{数据分析的需求或者目标}\n" +
//            "原始数据：\n" +
//            "{csv格式的原始数据，用,作为分隔符}\n" +
//            "请根据这两部分内容，严格按照以下指定格式生成内容（此外不要输出任何多余的开头、结尾、注释）\n" +
//            "【【【【【\n" +
//            "{前端 Echarts V5 的 option 配置对象 JSON 代码, 不要生成任何多余的内容，比如注释和代码块标记}\n" +
//            "【【【【【\n" +
//            "{明确的数据分析结论、越详细越好，不要生成多余的注释} \n" +
//            "最终格式是:  【【【【【 前端代码【【【【【分析结论 \n";


    public static final String ANSWER_PRECONDITION = "你是一个问题回答专家，接下来我会按照以下固定格式给你提供内容，然后生成答案即可：\n" +
            "            问题类型：\n" +
            "            问题名称：\n" +
            "            问题概述：";

    public static final String ESSAY_PRECONDITION = "你是一个作家，接下来接下来我会按照以下固定格式给你提供内容：\n" +
            "          文章描述：\n" +
            "          文章类型：\n" +
            "          请根据这两部分内容，严格按照这段话标准生成文章标题和内容即可，（注意：生成的内容文章标题和文章类型必须和我提交的保持一直）";

    /**
     * 向 AI 发送请求
     *
     * @return
     */
    public String sendMesToAIUseXingHuo(final String content) {
        List<SparkMessage> messages = new ArrayList<>();
        messages.add(SparkMessage.userContent(content));
        // 构造请求
        SparkRequest sparkRequest = SparkRequest.builder()
                // 消息列表
                .messages(messages)
                // 模型回答的tokens的最大长度,非必传,取值为[1,4096],默认为2048
                .maxTokens(2048)
                // 核采样阈值。用于决定结果随机性,取值越高随机性越强即相同的问题得到的不同答案的可能性越高 非必传,取值为[0,1],默认为0.5
                .temperature(0.2)
                // 指定请求版本，默认使用最新2.0版本
                .apiVersion(SparkApiVersion.V3_5)
                .build();
        // 同步调用
        SparkSyncChatResponse chatResponse = sparkClient.chatSync(sparkRequest);
        String responseContent = chatResponse.getContent();
        log.info("星火 AI 返回的结果 {}", responseContent);
        return responseContent;
    }

    /**
     * AI 对话
     *
     * @param message 消息
     * @param modeId
     * @return
     */
    public String doChat(String message, Long modeId) {
        DevChatRequest devChatRequest = new DevChatRequest();
        // 鱼聪明平台模型ID
        devChatRequest.setModelId(aiModelConfig.getModelId());
        devChatRequest.setMessage(message);
        BaseResponse<DevChatResponse> response = congMingClient.doChat(devChatRequest);
        if (response == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "AI 响应错误");
        }
        return response.getData().getContent();
    }

    public String doAiChat(Long modelId, String message) {
        DevChatRequest devChatRequest = new DevChatRequest();
        devChatRequest.setModelId(modelId);
        devChatRequest.setMessage(message);
        BaseResponse<DevChatResponse> response = congMingClient.doChat(devChatRequest);
        if (response == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "AI 响应错误");
        }
        return response.getData().getContent();
    }
}
