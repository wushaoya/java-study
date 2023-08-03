package com.example.springboot05.mybatis.controller;

import com.example.springboot05.mybatis.entity.QrtzLocks;
import com.example.springboot05.mybatis.mapper.blog.QrtzLocksMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author wushaoya
 * @date 2023-06-09
 * Time: 9:56
 */
@RestController
public class QrtzLocksController {

    @Autowired
    private QrtzLocksMapper qrtzLocksMapper;

    @RequestMapping("/qrtz")
    public List<QrtzLocks> getList() {
        return qrtzLocksMapper.getQrtzLocks();
    }

}
