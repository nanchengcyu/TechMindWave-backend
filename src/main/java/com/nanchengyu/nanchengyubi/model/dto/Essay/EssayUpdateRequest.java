package com.nanchengyu.nanchengyubi.model.dto.Essay;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.io.Serializable;

/**
 * 更新请求
 *
 * @author <a href="https://github.com/liyupi">程序员鱼皮</a>
 * @from <a href="https://yupi.icu">编程导航知识星球</a>
 */
@Data
public class EssayUpdateRequest implements Serializable {

    /**
     * id
     */
    @TableId(type = IdType.ASSIGN_ID)
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
     * 生成的图表信息
     */
    private String genEssay;


    /**
     * 创建图标用户 id
     */
    private Long userId;

    /**
     * 是否删除
     */
    @TableLogic
    private Integer isDelete;

    private static final long serialVersionUID = 1L;
}