package com.daiyu.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by dyx on 2021/10/22
 */
@RestController
public class LoginController {

//    @RequestMapping("/login")
//    public String login(){
//        System.out.println("登录");
//        return "redirect:main.html";
//    }

    @RequestMapping("/toMain")
    public String toMain(){
        return "redirect:main.html";

    }

}
