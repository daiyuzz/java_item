package com.daiyu.security.mapper;

import com.daiyu.security.bean.MyUserBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * created by dyx on 2021/11/10
 * 数据表user的mapper类
 **/
@Mapper
@Component
public interface MyUserMapper {

    @Select("select * from user where username = #{username}")
    MyUserBean selectByUsername(@Param("username") String username);
}
