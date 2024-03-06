package com.nanchengyu.nanchengyubi.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.nanchengyu.nanchengyubi.common.ErrorCode;
import com.nanchengyu.nanchengyubi.exception.ThrowUtils;
import lombok.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 图表信息表
 * @TableName chart
 */
@TableName(value ="chart")
@Data
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Chart implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 分析目标
     */
    private String goal;

    /**
     * 图表数据
     */
    private String chartData;


    /**
     * 图表名称
     */
    private String chartName;

    /**
     * 图表类型
     */
    private String chartType;

    /**
     * 生成的图表信息
     */
    private String genChart;

    /**
     * 图表状态 wait-等待,running-生成中,succeed-成功生成,failed-生成失败
     */
    private String chartStatus;

    /**
     * 执行信息
     */
    private String execMessage;

    /**
     * 生成的分析结论
     */
    private String genResult;

    /**
     * 创建图标用户 id
     */
    private Long userId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否删除
     */
    @TableLogic
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    public Chart(Long id, String status, String execMessage) {
        ThrowUtils.throwIf((id == null || id < 0) || StringUtils.isAnyEmpty(status), ErrorCode.PARAMS_ERROR);
        this.id = id;
        this.chartStatus = status;
        this.execMessage = execMessage;
    }

    public Chart(Long id, String genChart, String genResult, String status, String execMessage) {
        ThrowUtils.throwIf((id == null || id < 0) || StringUtils.isAnyEmpty(genChart, genResult, status), ErrorCode.PARAMS_ERROR);
        this.id = id;
        this.genChart = genChart;
        this.genResult = genResult;
        this.chartStatus = status;
        this.execMessage = execMessage;
    }
}