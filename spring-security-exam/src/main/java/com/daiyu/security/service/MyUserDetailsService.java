package com.daiyu.security.service;

import com.daiyu.security.bean.MyUserBean;
import com.daiyu.security.mapper.MyUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * created by dyx on 2021/11/10
 * UserDetailsService的实现类，用于在程序中引入一个自定义的AuthenticationProvider，实现数据库访问模式验证
 **/
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private MyUserMapper myUserMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUserBean myUserBean = myUserMapper.selectByUsername(username);
        if (Objects.isNull(myUserBean)){
            throw new UsernameNotFoundException("数据库中无此用户");
        }
        return myUserBean;
    }
}
