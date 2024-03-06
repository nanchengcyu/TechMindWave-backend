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
     * 动态的创建数据库
     * @param creatTableSQL
     */
    void createTable(final String creatTableSQL);

    /**
     * 向动态创建的数据库之中插入数据
     *
     * @param insertCVSData
     * @return
     */
    void insertValue(final String insertCVSData);

    /**
     * @param querySql
     * @return
     */
    List<Map<String, Object>> queryChartData(String querySql);
}




