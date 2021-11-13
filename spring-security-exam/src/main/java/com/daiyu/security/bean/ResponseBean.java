package com.daiyu.security.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * created by dyx on 2021/11/12
 * 返回服务器状态的bean类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseBean {

    private Integer status;
    private String msg;
    private Object obj;
}
