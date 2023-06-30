package com.controller;

import com.pojo.Users;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * @date 2021/9/1
 */
@Controller()
public class UserController {

    /**
     * 用户注册页面
     * @return
     */
    @RequestMapping("/addUser")
    public String showPage(Users users){
        return "addUser";
    }

    /**
     * 操作成功页面
     * Valid ： 开启对user对象属性值的校验
     * BindingResult ：
     * @return
     */
    @RequestMapping("/saveUser")
    public String saveUser(@Valid Users users, BindingResult result){
        System.out.println(users);
        return "OK";
    }
}
