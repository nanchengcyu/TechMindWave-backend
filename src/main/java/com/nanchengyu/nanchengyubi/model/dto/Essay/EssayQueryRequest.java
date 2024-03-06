package com.nanchengyu.nanchengyubi.model.dto.Essay;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.nanchengyu.nanchengyubi.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 查询请求
 *
 * @author <a href="https://github.com/liyupi">程序员鱼皮</a>
 * @from <a href="https://yupi.icu">编程导航知识星球</a>
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class EssayQueryRequest extends PageRequest implements Serializable {

    /**
     * id
     */

    private Long id;



    /**
     * 图表名称
     */
    private String essayName;

    /**
     * 图表类型
     */
    private String essayType;

    /**
     * 创建图标用户 id
     */
    private Long userId;



    private static final long serialVersionUID = 1L;
}