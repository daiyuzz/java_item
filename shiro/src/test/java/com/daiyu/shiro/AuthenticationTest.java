package com.daiyu.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by dyx on 2021/7/19
 */
public class AuthenticationTest {

    SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();

    @Before
    public void addUser() {
        simpleAccountRealm.addAccount("qwe", "123");
    }

    @Test
    public void testAuthentication() {

        // 1.构建securityManager环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(simpleAccountRealm);

        //2.主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager); // 设置SecurityManager环境
        Subject subject = SecurityUtils.getSubject(); //获取当前主体

        UsernamePasswordToken token = new UsernamePasswordToken("qwe", "123");
        subject.login(token); // 登录

        System.out.println("isAuthentication:" + subject.isAuthenticated());

        subject.logout();

        System.out.println("isAuthentication:" + subject.isAuthenticated());

    }
}
