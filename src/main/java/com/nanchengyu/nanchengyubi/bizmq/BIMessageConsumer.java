package com.nanchengyu.nanchengyubi.bizmq;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.nanchengyu.nanchengyubi.common.ErrorCode;
import com.nanchengyu.nanchengyubi.constant.BiMqConstant;
import com.nanchengyu.nanchengyubi.constant.ChartConstant;
import com.nanchengyu.nanchengyubi.exception.BusinessException;
import com.nanchengyu.nanchengyubi.exception.ThrowUtils;
import com.nanchengyu.nanchengyubi.manager.AiManager;
import com.nanchengyu.nanchengyubi.mapper.ChartMapper;
import com.nanchengyu.nanchengyubi.model.dto.chart.ChartGenResult;
import com.nanchengyu.nanchengyubi.model.entity.Chart;
import com.nanchengyu.nanchengyubi.service.ChartService;
import com.nanchengyu.nanchengyubi.utils.ChartDataUtil;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author <a href="https://github.com/lieeew">leikooo</a>
 */
@Slf4j
@Component
public class BIMessageConsumer {

    @Resource
    private ChartService chartService;

    @Resource
    private AiManager aiManager;

    @Resource
    private ChartMapper chartMapper;
//
//    /**
//     * 消费正常消息
//     *
//     * @param message
//     * @param channel
//     * @param deliveryTag
//     */
//    @RabbitListener(queues = {BiMqConstant.BI_QUEUE_NAME}, ackMode = "MANUAL")
//    public void receiveMessage(String message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag) {
//        if (StringUtils.isBlank(message)) {
//            throwExceptionAndNackMessage(channel, deliveryTag);
//        }
//        log.info("receiveMessage message = {}", message);
//        Chart chart = chartService.getById(message);
//        if (chart == null) {
//            throwExceptionAndNackMessage(channel, deliveryTag);
//        }
//        Long userId = chart.getUserId();
//        // 检查用户任务计数器
//        int userTaskCount = (int) getRunningTaskCount(userId);
//        try {
//            if (userTaskCount <= BiMqConstant.MAX_CONCURRENT_CHARTS) {
//                chartService.updateById(new Chart(Long.parseLong(message), ChartConstant.CHART_STATUS_RUNNING, ""));
//                String csvData = ChartDataUtil.changeDataToCSV(chartMapper.queryChartData(String.valueOf(Long.parseLong(message))));
//                ThrowUtils.throwIf(StringUtils.isBlank(csvData), ErrorCode.PARAMS_ERROR);
//                ChartGenResult genResult = ChartDataUtil.getGenResult(aiManager, chart.getGoal(), csvData, chart.getChartType());
//                boolean result = chartService.updateById(new Chart(chart.getId(), genResult.getGenChart(), genResult.getGenResult(), ChartConstant.CHART_STATUS_SUCCEED, ""));
//                if (!result) {
//                    throwExceptionAndNackMessage(channel, deliveryTag);
//                }
//                channel.basicAck(deliveryTag, false);
//                return;
//            }
//            channel.basicNack(deliveryTag, false, true);
//        } catch (Exception e) {
//            log.error(e.getMessage());
//            try {
//                channel.basicNack(deliveryTag, false, false);
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        }
//    }
//
//    /**
//     * 消费异常消息
//     *
//     * @param message
//     * @param channel
//     * @param deliveryTag
//     */
//    @RabbitListener(queues = {BiMqConstant.BI_DLX_QUEUE_NAME}, ackMode = "MANUAL")
//    public void receiveErrorMessage(String message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag) {
//        if (StringUtils.isBlank(message)) {
//            throwExceptionAndNackMessage(channel, deliveryTag);
//        }
//        log.info("receiveErrorMessage message = {}", message);
//        Chart chart = chartService.getById(message);
//        if (chart == null) {
//            throwExceptionAndNackMessage(channel, deliveryTag);
//        }
//        chartService.updateById(new Chart(Long.parseLong(message), ChartConstant.CHART_STATUS_FAILED, ""));
//        try {
//            channel.basicAck(deliveryTag, false);
//        } catch (IOException e) {
//            log.error(e.getMessage());
//        }
//    }

    /**
     * 抛异常同时拒绝消息
     *
     * @param channel
     * @param deliveryTag
     */
    private void throwExceptionAndNackMessage(Channel channel, long deliveryTag) {
        try {
            channel.basicNack(deliveryTag, false, false);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        throw new BusinessException(ErrorCode.SYSTEM_ERROR);
    }

    /**
     * 获取当前用户正在运行的任务数量，就算服务器出现问题，数据已经持久化到硬盘之中
     *
     * @param userId
     * @return
     */
    private long getRunningTaskCount(Long userId) {
        QueryWrapper<Chart> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userId", userId).eq("status", ChartConstant.CHART_STATUS_RUNNING);
        return chartService.count(queryWrapper);
    }
}

