package com.dict.controller;

import com.dict.service.SystemBaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 系统基础信息模块
 * @date 2022/1/14
 */
@Controller
@RequestMapping("/sys")
public class SystemBaseInfoController {

    @Autowired(required = false)
    private SystemBaseInfoService systemBaseInfoService;

    /**
     * 页面跳转
     *
     * @param page
     * @return
     */
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page) {
        return page;
    }

    /**
     * 系统基础信息
     *
     * @return
     */
    @RequestMapping("/workspace")
    @ResponseBody
    public Integer getWorkSpaceNum() {
        return systemBaseInfoService.getWorkSpaceNum();
    }

    /**
     * 有效用户数
     * @return
     */
    @RequestMapping("/user")
    @ResponseBody
    public Integer getValidUser(){
        return systemBaseInfoService.getValidUser();
    }

    /**
     * 有效部门数
     * @return
     */
    @RequestMapping("/department")
    @ResponseBody
    public Integer getValidDepartment(){
        return systemBaseInfoService.getValidDepartment();
    }

    /**
     * 有效数据源数
     * @return
     */
    @RequestMapping("/datasource")
    @ResponseBody
    public Integer getValidDatasource(){
        return systemBaseInfoService.getValidDatasource();
    }
}
