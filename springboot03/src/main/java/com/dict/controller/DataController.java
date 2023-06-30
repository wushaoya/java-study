package com.dict.controller;

import com.dict.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @date 2022/1/17
 */
@Controller
@RequestMapping("/data")
public class DataController {
    @Autowired
    private DataService dataService;

    /**
     * 数据清洗数
     *
     * @return
     */
    @RequestMapping("/clean")
    @ResponseBody
    public Integer getCleanedData() {
        return dataService.getSynchronizedData() + dataService.getSynchronizedFile();
    }

    /**
     * 数据项映射数
     *
     * @return
     */
    @RequestMapping("/map")
    @ResponseBody
    public Integer getDataMap() {
        return dataService.getDataMap();
    }

    /**
     * 订阅数
     *
     * @return
     */
    @RequestMapping("/subscribe")
    @ResponseBody
    public Integer getSubscribeNum() {
        return dataService.getSubscribeNum();
    }

    /**
     * 共享出去的数据条数
     * @return
     */
    @RequestMapping("/shared")
    @ResponseBody
    public Integer getShared(){
        return dataService.getShared();
    }

    /**
     *
     * @return
     */
    @RequestMapping("/distribution")
    @ResponseBody
    public List<String> getDataDistribution(){
        List<String> proposer = dataService.getProposerID();
        return null;
    }
}
