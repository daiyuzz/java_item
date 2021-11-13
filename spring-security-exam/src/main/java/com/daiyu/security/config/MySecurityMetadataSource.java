package com.daiyu.security.config;

import com.daiyu.security.bean.MyResourceBean;
import com.daiyu.security.mapper.ResourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 * created by dyx on 2021/11/12
 * 自定义的元类数据源类，用来提供鉴权过程中访问资源所需要的角色
 */
@Component
public class MySecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    @Autowired
    private ResourceMapper resourceMapper;
    // 本方法返回访问资源所需的角色集合
    AntPathMatcher antPathMatcher = new AntPathMatcher();


    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        // 从object中得到所需访问的资源，即网址
        String requestUrl = ((FilterInvocation) object).getRequestUrl();
        // 从数据库中得到所有资源，以及对应的角色
        List<MyResourceBean> resourceBeans = resourceMapper.selectAllResource();
        for (MyResourceBean resourceBean : resourceBeans) {
            // 首先进行地址匹配
            if (antPathMatcher.match(resourceBean.getUrl(), requestUrl) && resourceBean.getRolesArray().length > 0) {
                return SecurityConfig.createList(resourceBean.getRolesArray());
            }
        }
        // 匹配不成功返回一个特殊的ROLE_NONE
        return SecurityConfig.createList("ROLE_NONE");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return FilterInvocation.class.isAssignableFrom(aClass);
    }
}
