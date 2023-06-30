package com.controller;

import com.entity.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * springboot整合jsp
 * @date 2021/8/25
 */
@Controller
public class UserController {

    @RequestMapping("/showUser")
    public String toShowUser(Model model){
        List<Users> list = new ArrayList<>();
        list.add(new Users(1, "Joker", 28));
        list.add(new Users(2, "Jim", 22));
        list.add(new Users(3, "Joe", 24));
        model.addAttribute("list", list);
        return "userList";
    }

}
