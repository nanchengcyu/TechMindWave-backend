package com.nanchengyu.nanchengyubi.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonValidator {
 public static final String CHART_DEFAULT=" if(!JsonValidator.isValidJson(preGenChart)){\n" +
         "            // throw new BusinessException(ErrorCode.SYSTEM_ERROR, \"AI生成错误\");\n" +
         "            chart.setGenChart(\"{\\n\" +\n" +
         "                    \"    \\\"title\\\": {\\n\" +\n" +
         "                    \"        \\\"text\\\": \\\"本季度招聘情况分析\\\",\\n\" +\n" +
         "                    \"        \\\"subtext\\\": \\\"详细展示了各部门的招聘录用情况\\\",\\n\" +\n" +
         "                    \"        \\\"left\\\": \\\"center\\\"\\n\" +\n" +
         "                    \"    },\\n\" +\n" +
         "                    \"    \\\"tooltip\\\": {\\n\" +\n" +
         "                    \"        \\\"trigger\\\": \\\"axis\\\",\\n\" +\n" +
         "                    \"        \\\"axisPointer\\\": {\\n\" +\n" +
         "                    \"            \\\"type\\\": \\\"shadow\\\"\\n\" +\n" +
         "                    \"        }\\n\" +\n" +
         "                    \"    },\\n\" +\n" +
         "                    \"    \\\"legend\\\": {\\n\" +\n" +
         "                    \"        \\\"data\\\": [\\n\" +\n" +
         "                    \"            \\\"应聘率\\\",\\n\" +\n" +
         "                    \"            \\\"面试率\\\",\\n\" +\n" +
         "                    \"            \\\"录用率\\\",\\n\" +\n" +
         "                    \"            \\\"招聘完成率\\\",\\n\" +\n" +
         "                    \"            \\\"报到率\\\"\\n\" +\n" +
         "                    \"        ]\\n\" +\n" +
         "                    \"    },\\n\" +\n" +
         "                    \"    \\\"grid\\\": {\\n\" +\n" +
         "                    \"        \\\"left\\\": \\\"3%\\\",\\n\" +\n" +
         "                    \"        \\\"right\\\": \\\"4%\\\",\\n\" +\n" +
         "                    \"        \\\"bottom\\\": \\\"3%\\\",\\n\" +\n" +
         "                    \"        \\\"containLabel\\\": true\\n\" +\n" +
         "                    \"    },\\n\" +\n" +
         "                    \"    \\\"xAxis\\\": [\\n\" +\n" +
         "                    \"        {\\n\" +\n" +
         "                    \"            \\\"type\\\": \\\"category\\\",\\n\" +\n" +
         "                    \"            \\\"boundaryGap\\\": false,\\n\" +\n" +
         "                    \"            \\\"data\\\": [\\n\" +\n" +
         "                    \"                \\\"办公室\\\",\\n\" +\n" +
         "                    \"                \\\"市场部\\\",\\n\" +\n" +
         "                    \"                \\\"技术部\\\",\\n\" +\n" +
         "                    \"                \\\"客服部\\\",\\n\" +\n" +
         "                    \"                \\\"研发部\\\",\\n\" +\n" +
         "                    \"                \\\"商务部\\\",\\n\" +\n" +
         "                    \"                \\\"营销部\\\"\\n\" +\n" +
         "                    \"            ]\\n\" +\n" +
         "                    \"        }\\n\" +\n" +
         "                    \"    ],\\n\" +\n" +
         "                    \"    \\\"yAxis\\\": [\\n\" +\n" +
         "                    \"        {\\n\" +\n" +
         "                    \"            \\\"type\\\": \\\"value\\\",\\n\" +\n" +
         "                    \"            \\\"name\\\": \\\"人数\\\",\\n\" +\n" +
         "                    \"            \\\"min\\\": 0,\\n\" +\n" +
         "                    \"            \\\"max\\\": 10,\\n\" +\n" +
         "                    \"            \\\"position\\\": \\\"right\\\",\\n\" +\n" +
         "                    \"            \\\"axisLine\\\": {\\n\" +\n" +
         "                    \"                \\\"lineStyle\\\": {\\n\" +\n" +
         "                    \"                    \\\"color\\\": \\\"#5793f3\\\"\\n\" +\n" +
         "                    \"                }\\n\" +\n" +
         "                    \"            },\\n\" +\n" +
         "                    \"            \\\"axisLabel\\\": {\\n\" +\n" +
         "                    \"                \\\"formatter\\\": \\\"{value}\\\"\\n\" +\n" +
         "                    \"            }\\n\" +\n" +
         "                    \"        }\\n\" +\n" +
         "                    \"    ],\\n\" +\n" +
         "                    \"    \\\"series\\\": [\\n\" +\n" +
         "                    \"        {\\n\" +\n" +
         "                    \"            \\\"name\\\": \\\"应聘率\\\",\\n\" +\n" +
         "                    \"            \\\"type\\\": \\\"bar\\\",\\n\" +\n" +
         "                    \"            \\\"stack\\\": \\\"总量\\\",\\n\" +\n" +
         "                    \"            \\\"label\\\": {\\n\" +\n" +
         "                    \"                \\\"show\\\": true,\\n\" +\n" +
         "                    \"                \\\"position\\\": \\\"insideRight\\\"\\n\" +\n" +
         "                    \"            },\\n\" +\n" +
         "                    \"            \\\"data\\\": [\\n\" +\n" +
         "                    \"                3,\\n\" +\n" +
         "                    \"                4,\\n\" +\n" +
         "                    \"                8,\\n\" +\n" +
         "                    \"                1,\\n\" +\n" +
         "                    \"                1,\\n\" +\n" +
         "                    \"                1,\\n\" +\n" +
         "                    \"                1\\n\" +\n" +
         "                    \"            ]\\n\" +\n" +
         "                    \"        },\\n\" +\n" +
         "                    \"        {\\n\" +\n" +
         "                    \"            \\\"name\\\": \\\"面试率\\\",\\n\" +\n" +
         "                    \"            \\\"type\\\": \\\"bar\\\",\\n\" +\n" +
         "                    \"            \\\"stack\\\": \\\"总量\\\",\\n\" +\n" +
         "                    \"            \\\"label\\\": {\\n\" +\n" +
         "                    \"                \\\"show\\\": true,\\n\" +\n" +
         "                    \"                \\\"position\\\": \\\"insideRight\\\"\\n\" +\n" +
         "                    \"            },\\n\" +\n" +
         "                    \"            \\\"data\\\": [\\n\" +\n" +
         "                    \"                3,\\n\" +\n" +
         "                    \"                3,\\n\" +\n" +
         "                    \"                6,\\n\" +\n" +
         "                    \"                1,\\n\" +\n" +
         "                    \"                1,\\n\" +\n" +
         "                    \"                2,\\n\" +\n" +
         "                    \"                2\\n\" +\n" +
         "                    \"            ]\\n\" +\n" +
         "                    \"        },\\n\" +\n" +
         "                    \"        {\\n\" +\n" +
         "                    \"            \\\"name\\\": \\\"录用率\\\",\\n\" +\n" +
         "                    \"            \\\"type\\\": \\\"bar\\\",\\n\" +\n" +
         "                    \"            \\\"stack\\\": \\\"总量\\\",\\n\" +\n" +
         "                    \"            \\\"label\\\": {\\n\" +\n" +
         "                    \"                \\\"show\\\": true,\\n\" +\n" +
         "                    \"                \\\"position\\\": \\\"insideRight\\\"\\n\" +\n" +
         "                    \"            },\\n\" +\n" +
         "                    \"            \\\"data\\\": [\\n\" +\n" +
         "                    \"                1,\\n\" +\n" +
         "                    \"                1,\\n\" +\n" +
         "                    \"                2,\\n\" +\n" +
         "                    \"                1,\\n\" +\n" +
         "                    \"                1,\\n\" +\n" +
         "                    \"                1,\\n\" +\n" +
         "                    \"                1\\n\" +\n" +
         "                    \"            ]\\n\" +\n" +
         "                    \"        },\\n\" +\n" +
         "                    \"        {\\n\" +\n" +
         "                    \"            \\\"name\\\": \\\"招聘完成率\\\",\\n\" +\n" +
         "                    \"            \\\"type\\\": \\\"bar\\\",\\n\" +\n" +
         "                    \"            \\\"stack\\\": \\\"总量\\\",\\n\" +\n" +
         "                    \"            \\\"label\\\": {\\n\" +\n" +
         "                    \"                \\\"show\\\": true,\\n\" +\n" +
         "                    \"                \\\"position\\\": \\\"insideRight\\\"\\n\" +\n" +
         "                    \"            },\\n\" +\n" +
         "                    \"            \\\"data\\\": [\\n\" +\n" +
         "                    \"                100,\\n\" +\n" +
         "                    \"                50,\\n\" +\n" +
         "                    \"                100,\\n\" +\n" +
         "                    \"                100,\\n\" +\n" +
         "                    \"                100,\\n\" +\n" +
         "                    \"                100,\\n\" +\n" +
         "                    \"                100\\n\" +\n" +
         "                    \"            ]\\n\" +\n" +
         "                    \"        },\\n\" +\n" +
         "                    \"        {\\n\" +\n" +
         "                    \"            \\\"name\\\": \\\"报到率\\\",\\n\" +\n" +
         "                    \"            \\\"type\\\": \\\"bar\\\",\\n\" +\n" +
         "                    \"            \\\"stack\\\": \\\"总量\\\",\\n\" +\n" +
         "                    \"            \\\"label\\\": {\\n\" +\n" +
         "                    \"                \\\"show\\\": true,\\n\" +\n" +
         "                    \"                \\\"position\\\": \\\"insideRight\\\"\\n\" +\n" +
         "                    \"            },\\n\" +\n" +
         "                    \"            \\\"data\\\": [\\n\" +\n" +
         "                    \"                100,\\n\" +\n" +
         "                    \"                50,\\n\" +\n" +
         "                    \"                100,\\n\" +\n" +
         "                    \"                100,\\n\" +\n" +
         "                    \"                100,\\n\" +\n" +
         "                    \"                100,\\n\" +\n" +
         "                    \"                100\\n\" +\n" +
         "                    \"            ]\\n\" +\n" +
         "                    \"        }\\n\" +\n" +
         "                    \"    ]\\n\" +\n" +
         "                    \"}\");\n" +
         "        }\n" +
         "        chart.setGenChart(preGenChart);";
    public static boolean isValidJson(String json) {
        try {
            new ObjectMapper().readTree(json);
            return true;
        } catch (JsonMappingException | com.fasterxml.jackson.core.JsonParseException e) {
            return false;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}