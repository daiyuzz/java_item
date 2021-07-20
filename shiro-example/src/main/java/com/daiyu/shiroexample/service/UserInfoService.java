package com.daiyu.shiroexample.service;

import com.daiyu.shiroexample.entity.UserInfo;

public interface UserInfoService {

    // 通过username查找用户信息
    public UserInfo findByUsername(String username);
}
