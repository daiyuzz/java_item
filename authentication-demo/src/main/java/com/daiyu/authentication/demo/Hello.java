package com.daiyu.authentication.demo;

import cn.hutool.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * created by dyx on 2022/2/8
 */
@Controller
public class Hello {

    @ResponseBody
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, @RequestBody JSONObject requestBody) {
        String username = requestBody.getStr("u");
        String password = requestBody.getStr("p");

        if ("user".equals(username) && "123456".equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("pass", true);
            return "Login success!";
        } else {
            return "Login failed";
        }
    }


    @ResponseBody
    @RequestMapping("visit")
    public String index(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Boolean pass = (Boolean) session.getAttribute("pass");
        if (pass != null && pass) {
            // 只有认证通过，才记录访问次数
            long time;
            if (session.getAttribute("time") == null) {
                time = 0;
                session.setAttribute("time", 1);
                System.out.println("[start]");
            } else {
                time = Integer.parseInt(session.getAttribute("time").toString());
                session.setAttribute("time", time + 1);
                System.out.println(time);
            }
            return String.format("No.%d", time + 1);
        } else {
            // 认证不通过，返回没有权限
            return "No Auth!";
        }
    }
}
