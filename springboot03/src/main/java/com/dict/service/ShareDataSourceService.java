package com.dict.service;

/**
 * @date 2022/1/17
 */
public interface ShareDataSourceService {
    // 库表资源个数
    Integer getResInfo(Integer sourceType);
    // 数据导出数
    Integer getExportedData();
}
