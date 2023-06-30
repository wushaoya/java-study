package com.dict.service.impl;

import com.dict.mapper.HostInfoMapper;
import com.dict.service.HostInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @date 2022/1/17
 */
@Service
@Transactional
public class HostInfoServiceImpl implements HostInfoService {
    @Autowired(required = false)
    private HostInfoMapper hostInfoMapper;
    @Override
    public Integer getTenement() {
        return hostInfoMapper.getTenement();
    }
}
