package com.dict.mapper;

import java.util.List;

/**
 * @date 2022/1/17
 */
public interface DataMapper {
    Integer getSynchronizedFile();
    Integer getSynchronizedData();
    Integer getDataMap();
    Integer getSubscribeNum();
    Integer getShared();
    List<String> getProposerID();
}
