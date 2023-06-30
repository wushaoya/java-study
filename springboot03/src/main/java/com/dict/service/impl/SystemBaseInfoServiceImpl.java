package com.dict.service.impl;

import com.dict.mapper.SystemBaseInfoMapper;
import com.dict.service.SystemBaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @date 2022/1/14
 */
@Service
@Transactional
public class SystemBaseInfoServiceImpl implements SystemBaseInfoService {

    @Autowired(required = false)
    private SystemBaseInfoMapper systemBaseInfoMapper;

    @Override
    public Integer getWorkSpaceNum() {
        return systemBaseInfoMapper.getWorkSpaceNum();
    }

    @Override
    public Integer getValidUser() {
        return systemBaseInfoMapper.getValidUser();
    }

    @Override
    public Integer getValidDepartment() {
        return systemBaseInfoMapper.getValidDepartment();
    }

    @Override
    public Integer getValidDatasource() {
        return systemBaseInfoMapper.getValidDatasource();
    }
}
