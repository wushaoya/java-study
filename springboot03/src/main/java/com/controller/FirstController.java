package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @date 2021/8/26
 */
@Controller
public class FirstController {

    @RequestMapping("/show")
    public String show(Model model, HttpServletRequest httpServletRequest){
        model.addAttribute("msg", "Thymeleaf入门");
        model.addAttribute("date",new Date());
        httpServletRequest.setAttribute("req","request");
        httpServletRequest.getSession().setAttribute("sess","httpSession");
        httpServletRequest.getSession().getServletContext().setAttribute("con","httpContext");
        return "index";
    }
}
