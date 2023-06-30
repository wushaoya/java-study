package com.dict.controller;

import com.dict.service.ShareDataSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 对外共享的资源模块
 * @date 2022/1/17
 */
@Controller
@RequestMapping("/share")
public class ShareDataSourceController {
    @Autowired
    private ShareDataSourceService shareDataSourceService;

    /**
     * 获取已被订阅的资源数量
     * @param sourceType 分三种 1、库表  2、文件  3、接口
     * @return
     */
    @RequestMapping("/resInfo")
    @ResponseBody
    public Integer getResInfo(Integer sourceType){
        return shareDataSourceService.getResInfo(sourceType);
    }

    /**
     * 数据开发兄台-数据导出数
     * @return
     */
    @RequestMapping("/expData")
    @ResponseBody
    public Integer getExportedData(){
        return shareDataSourceService.getExportedData();
    }
}
