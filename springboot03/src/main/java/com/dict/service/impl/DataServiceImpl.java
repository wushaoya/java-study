package com.dict.service.impl;

import com.dict.mapper.DataMapper;
import com.dict.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @date 2022/1/17
 */
@Service
@Transactional
public class DataServiceImpl implements DataService {
    @Autowired(required = false)
    private DataMapper dataMapper;
    @Override
    public Integer getSynchronizedFile() {
        return dataMapper.getSynchronizedFile();
    }

    @Override
    public Integer getSynchronizedData() {
        return dataMapper.getSynchronizedData();
    }

    @Override
    public Integer getDataMap() {
        return dataMapper.getDataMap();
    }

    @Override
    public Integer getSubscribeNum() {
        return dataMapper.getSubscribeNum();
    }

    @Override
    public Integer getShared() {
        return dataMapper.getShared();
    }

    @Override
    public List<String> getProposerID() {
        return dataMapper.getProposerID();
    }
}
