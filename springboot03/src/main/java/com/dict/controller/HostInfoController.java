package com.dict.controller;

import com.dict.service.HostInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @date 2022/1/17
 */
@Controller
@RequestMapping("/host")
public class HostInfoController {
    @Autowired(required = false)
    private HostInfoService hostInfoService;

    /**
     * 获取租户数
     * @return
     */
    @RequestMapping("/tenement")
    @ResponseBody
    public Integer getTenement(){
        return hostInfoService.getTenement();
    }
}
