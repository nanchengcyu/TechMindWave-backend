package com.nanchengyu.nanchengyubi.model.vo;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author nanchengyu
 * CreateTime 2023/5/21 12:41
 * BI 返回结果
 */
@Data
@Getter
@NoArgsConstructor
public class BiResponse {

    private String genChart;

    private String genResult;
    /**
     * 新生成的ID
     */
    private Long chartId;

    private Date createTime;

    private String chartType;

    private String goal;

    private String chartData;

    private String chartName;
    public BiResponse(Long chartId) {
        this.chartId = chartId;
    }
}
