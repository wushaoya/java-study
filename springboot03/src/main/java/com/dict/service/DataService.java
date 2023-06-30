package com.dict.service;

import java.util.List;

/**
 * @date 2022/1/17
 */
public interface DataService {
    // 文件同步任务统计表记录数
    Integer getSynchronizedFile();
    // 数据同步任务统计表记录数
    Integer getSynchronizedData();
    // 数据项映射数
    Integer getDataMap();
    // 获取订阅数
    Integer getSubscribeNum();
    // 共享出去的数据条数
    Integer getShared();
    // 获取申请人ID
    List<String> getProposerID();
}
