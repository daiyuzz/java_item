package com.daiyu.security.config;

import com.daiyu.security.handle.MyAccessDeniedHandler;
import com.daiyu.security.handle.MyAuthenticationFailureHandler;
import com.daiyu.security.handle.MyAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * created by dyx on 2021/10/22
 * SpringSecurity 配置类
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyAccessDeniedHandler myAccessDeniedHandler;

    // 自定义登录页面替换 SpringSecurity 自带的登录页面
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 表单提交
        http.formLogin()
                // 当发现/login时认为是登录，必须和表单提交的地址一样，去执行UserDetailServiceImpl
                .loginProcessingUrl("/login")
                // 自定义登录页面
                .loginPage("/login.html")
                // 登陆成功后跳转的页面,post请求
//                .successForwardUrl("/toMain")
                .successHandler(new MyAuthenticationSuccessHandler("http://www.baidu.com"))
                // 登录失败跳转页面，post
//                .failureForwardUrl("/toError");
                .failureHandler(new MyAuthenticationFailureHandler("/error.html"));


        // 授权认证
        http.authorizeRequests()
                // login.html不需要被认证,否则访问login.html页面会被无限重定向到login.html
                .antMatchers("/login.html").permitAll()
                .antMatchers("/error.html").permitAll()
                .antMatchers("/js/**","/css/**","/images/**").permitAll()
                .regexMatchers(".+[.]png").permitAll()
                .antMatchers("/main.html").hasIpAddress("127.0.0.1")
                // 所有请求都必须被认证，必须登录之后被访问
                .anyRequest().authenticated();



        // 关闭csrf防护
        http.csrf().disable();


        // 异常处理
        http.exceptionHandling()
                .accessDeniedHandler(myAccessDeniedHandler);
    }

    @Bean
    public PasswordEncoder getPw(){
        return new BCryptPasswordEncoder();
    }


}
