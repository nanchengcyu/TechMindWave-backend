package com.nanchengyu.nanchengyubi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nanchengyu.nanchengyubi.model.entity.Chart;

import java.util.List;
import java.util.Map;

/**
* @author nanchengyu
* @description 针对表【chart(图表信息表)】的数据库操作Mapper
* @createDate 2023-05-14 19:20:33
* @Entity com.nanchengyu.nanchengyubi.model.entity.Chart
*/
public interface ChartMapper extends BaseMapper<Chart> {

    /**
     * @param querySql
     * @return
     */
    List<Map<String, Object>> queryChartData(String querySql);
}




