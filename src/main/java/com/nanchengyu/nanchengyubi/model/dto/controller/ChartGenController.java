package com.nanchengyu.nanchengyubi.model.dto.controller;

import com.nanchengyu.nanchengyubi.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * ClassName: ChartGenController
 * Package: com.nanchengyu.nanchengyubi.model.dto.controller
 * Description:
 *
 * @Author 南城余
 * @Create 2024/3/5 10:43
 * @Version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ChartGenController implements Serializable {

    private static final long serialVersionUID = 847541708929254846L;

    /**
     * 图标名称
     */
    private String chartName;

    /**
     * 分析目标
     */
    private String goal;

    /**
     * 图表类型
     */
    private String chartType;

    /**
     * 登录的用户
     */
    private User loginUser;

    public Long getLoginUserId() {
        return loginUser.getId();
    }
}
