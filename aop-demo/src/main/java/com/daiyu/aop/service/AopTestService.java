package com.daiyu.aop.service;

import com.daiyu.aop.controller.request.ParamRequest;
import com.daiyu.aop.controller.response.ResultResponse;

import java.util.List;

/**
 * created by dyx on 2021/11/24
 */
public interface AopTestService {

    List<ResultResponse> getResult(ParamRequest request);

    Integer getResult(Integer age, String name);
}
