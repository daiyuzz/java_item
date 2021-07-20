package com.daiyu.shiroexample.service.impl;

import com.daiyu.shiroexample.dao.UserInfoDao;
import com.daiyu.shiroexample.entity.UserInfo;
import com.daiyu.shiroexample.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoDao userInfoDao;

    @Override
    public UserInfo findByUsername(String username) {
        return userInfoDao.findByUserName(username);
    }
}
