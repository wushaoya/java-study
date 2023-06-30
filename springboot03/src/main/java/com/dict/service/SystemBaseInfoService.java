package com.dict.service;

import org.springframework.stereotype.Service;

/**
 * @date 2022/1/14
 */
public interface SystemBaseInfoService {
    // 有效工作控件数
    Integer getWorkSpaceNum();
    // 有效用户数
    Integer getValidUser();
    // 有效部门数
    Integer getValidDepartment();
    // 有效数据源数
    Integer getValidDatasource();
}
