package com.nanchengyu.nanchengyubi.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author nanchengyu
 * CreateTime 2023/5/21 12:41
 * 返回结果
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EssayResponse {
    private String essayTitle;

    private String essayType;

    private String essayContent;
}
