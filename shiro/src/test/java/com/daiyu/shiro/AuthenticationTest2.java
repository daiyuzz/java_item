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
public class AuthenticationTest2 {

    SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();

    @Before //在方法开始前添加一个用户，让他具备admin和user两个角色
    public void addUser() {
        simpleAccountRealm.addAccount("123", "123", "admin", "user");

    }

    @Test
    public void testAuthentication() {
        // 构建SecurityManager 环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(simpleAccountRealm);

        // 2.主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("123", "123");
        subject.login(token);

        System.out.println("isAuthentication:" + subject.isAuthenticated());

        // 判断subject是否具有admin和user两个角色权限，没有会报错
        subject.checkRoles("admin", "user");

    }

}
