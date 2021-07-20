package com.daiyu.shiro;

import com.daiyu.shiro.example.MyRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * created by dyx on 2021/7/20.
 */
public class AuthenticationTest3 {

    @Test
    public void testAuthentication(){
        MyRealm myRealm = new MyRealm(); // 实现自己的realm实例

        // 构建SecurityManager环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(myRealm);

        // 主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("qwe","123");
        subject.login(token);

        System.out.println("isAuthentication:"+subject.isAuthenticated());
        subject.checkRoles("admin","user");




    }
}
