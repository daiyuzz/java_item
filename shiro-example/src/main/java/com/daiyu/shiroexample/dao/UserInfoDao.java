package com.daiyu.shiroexample.dao;

import com.daiyu.shiroexample.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoDao extends JpaRepository<UserInfo,Long> {
    // 通过username查找用户信息
    public UserInfo findByUserName(String username);
}
