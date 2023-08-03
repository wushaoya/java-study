package com.example.springboot05.mybatis.controller;

import com.example.springboot05.mybatis.entity.User;
import com.example.springboot05.mybatis.mapper.user.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author wushaoya
 * @date 2023-06-09
 * Time: 9:54
 */
@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/user")
    public List<User> getUsers(){
        return userMapper.getList();
    }

}
