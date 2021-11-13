package com.daiyu.security.bean;

import lombok.Data;

/**
 * created by dyx on 2021/11/11
 * 资源表resource对应的类
 */
@Data
public class MyResourceBean {

    private Long id;

    private String url;

    private String roles;

    public String[] getRolesArray(){
        return roles.split(",");
    }

}
