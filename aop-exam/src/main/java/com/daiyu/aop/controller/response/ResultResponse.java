package com.daiyu.aop.controller.response;

import lombok.Data;

/**
 * created by dyx on 2021/11/24
 */
@Data
public class ResultResponse {

    private Integer code;

    private String message;

    private Object data;
}
