package com.daiyu.security.mapper;

import com.daiyu.security.bean.MyResourceBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * created by dyx on 2021/11/12
 */
@Component
@Mapper
public interface ResourceMapper {

    @Select("select * from resource")
    List<MyResourceBean> selectAllResource();

}
