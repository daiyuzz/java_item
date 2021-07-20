package com.daiyu.shiroexample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class HomeController {

    @RequestMapping({"/","/index"})
    public String index(){
        return "/index";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, Map<String,Object> map) throws Exception{
        System.out.println("HomeController.login()");
        // 登陆失败从request中获取shiro处理的异常信息
        // shiroLoginFailure 就是shiro异常类的全类名
        String exception = (String) request.getAttribute("shiroLoginFailure");
        System.out.println("exception=" + exception);
        String msg = "";
        return null;
    }
}
