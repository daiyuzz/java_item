package com.daiyu.aop.service;

import com.daiyu.aop.controller.request.ParamRequest;
import com.daiyu.aop.controller.response.ResultResponse;

/**
 * created by dyx on 2021/11/24
 */
public interface AopTestService {

    Integer getResult(ParamRequest request);
}
