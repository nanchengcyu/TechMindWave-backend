package com.nanchengyu.nanchengyubi.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * ClassName: Eassy
 * Package: com.nanchengyu.nanchengyubi.model.entity
 * Description:
 *
 * @Author 南城余
 * @Create 2024/3/6 10:01
 * @Version 1.0
 */
@TableName(value ="essay")
@Data
public class Essay implements Serializable {
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

}
