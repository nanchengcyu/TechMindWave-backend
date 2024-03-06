package com.nanchengyu.nanchengyubi.utils;

import cn.hutool.core.collection.CollUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * Excel 相关工具类
 */
@Slf4j
public class ExcelUtils {

    public static String getExcelFileName(final MultipartFile multipartFile) {
        try (InputStream inputStream = multipartFile.getInputStream()) {
            List<Map<Integer, String>> excelData = EasyExcel.read(inputStream).excelType(ExcelTypeEnum.XLSX).sheet().headRowNumber(0).doReadSync();
            // 读取表头 LinkedHashMap 是按照顺序读取的
            LinkedHashMap<Integer, String> headerMap = (LinkedHashMap<Integer, String>) excelData.get(0);
            List<String> headerList = headerMap.values().stream()
                    .filter(org.apache.commons.lang3.ObjectUtils::isNotEmpty)
                    .collect(Collectors.toList());
            // 读取数据
            List<String> dataLines = excelData.stream()
                    .skip(1) // 跳过表头
                    .map(dataMap -> dataMap.values().stream()
                            .filter(org.apache.commons.lang3.ObjectUtils::isNotEmpty)
                            .collect(Collectors.joining(","))) // 拼接数据字段
                    .collect(Collectors.toList());
            // 使用 StringJoiner 来构建 CSV 字符串
            StringJoiner csvContent = new StringJoiner("\n");
            csvContent.add(String.join(",", headerList)); // 添加表头
            dataLines.forEach(csvContent::add); // 添加数据行
            // System.out.println(csvContent);
            return csvContent.toString();
        } catch (Exception e) {
            log.error("读取excel文件失败: ", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * excel 转 csv
     *
     * @param multipartFile
     * @return
     */
    public static String excelToCsv(MultipartFile multipartFile) {
//        File file = null;
//        try {
//            file = ResourceUtils.getFile("classpath:网站数据.xlsx");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
        // 读取数据
        List<Map<Integer, String>> list = null;
        try {
            list = EasyExcel.read(multipartFile.getInputStream())
                    .excelType(ExcelTypeEnum.XLSX)
                    .sheet()
                    .headRowNumber(0)
                    .doReadSync();
        } catch (IOException e) {
            log.error("表格处理错误", e);
        }
        if (CollUtil.isEmpty(list)) {
            return "";
        }
        // 转换为 csv
        StringBuilder stringBuilder = new StringBuilder();
        // 读取表头
        LinkedHashMap<Integer, String> headerMap = (LinkedHashMap) list.get(0);
        // 过滤null数据
        List<String> headerList = headerMap.values().stream().filter(ObjectUtils::isNotEmpty).collect(Collectors.toList());
        stringBuilder.append(StringUtils.join(headerList, ",")).append("\n");
        // 读取数据
        for (int i = 1; i < list.size(); i++) {
            LinkedHashMap<Integer, String> dataMap = (LinkedHashMap) list.get(i);
            List<String> dataList = dataMap.values().stream().filter(ObjectUtils::isNotEmpty).collect(Collectors.toList());
            stringBuilder.append(StringUtils.join(dataList, ",")).append("\n");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        excelToCsv(null);
    }
}
