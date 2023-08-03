package com.example.springboot05.mybatis.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author wushaoya
 * @date 2023-06-15
 * Time: 13:52
 */
@RestController
public class TestController {

    @RequestMapping("/test")
    public String test(@RequestBody Map<String,Object> requestBody){
        System.out.println(requestBody);
        return "ok";
    }

}
