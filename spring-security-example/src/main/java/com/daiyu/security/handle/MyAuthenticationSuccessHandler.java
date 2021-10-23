package com.daiyu.security.handle;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dyx on 2021/10/23
 */
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private String url;

    public MyAuthenticationSuccessHandler(String url){
        this.url = url;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        User user = (User) authentication.getPrincipal();
        System.out.println(user.getUsername());
        // 处于安全原因password并不会被打印出来，会打印出null
        System.out.println(user.getPassword());
        System.out.println(user.getAuthorities());
        response.sendRedirect(url);



    }
}
