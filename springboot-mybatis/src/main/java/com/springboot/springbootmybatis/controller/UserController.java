package com.springboot.springbootmybatis.controller;

import com.springboot.springbootmybatis.mapper.UserMapper;
import com.springboot.springbootmybatis.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author wushaoya
 * @date 2022-08-14
 * Time: 16:47
 */
@RestController
public class UserController {

    @Autowired
    private UserMapper mapper;

    @RequestMapping("getUsers")
    public List<User> getUsers(){
        return mapper.getUsers();
    }
}
