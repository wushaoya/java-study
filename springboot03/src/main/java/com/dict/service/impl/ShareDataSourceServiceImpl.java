package com.dict.service.impl;

import com.dict.mapper.ShareDataSourceMapper;
import com.dict.service.ShareDataSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @date 2022/1/17
 */
@Service
@Transactional
public class ShareDataSourceServiceImpl implements ShareDataSourceService {
    @Autowired(required = false)
    private ShareDataSourceMapper shareDataSourceMapper;
    @Override
    public Integer getResInfo(Integer sourceType) {
        return shareDataSourceMapper.getResInfo(sourceType);
    }

    @Override
    public Integer getExportedData() {
        return shareDataSourceMapper.getExportedData();
    }
}
