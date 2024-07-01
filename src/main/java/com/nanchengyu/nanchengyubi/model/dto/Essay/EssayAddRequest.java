package com.nanchengyu.nanchengyubi.model.dto.Essay;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 创建请求
 */
@Data
public class EssayAddRequest implements Serializable {




    /**
     * 图表名称
     */
    private String essayName;

    /**
     * 图表类型
     */
    private String essayType;




    private static final long serialVersionUID = 1L;
}