package com.daiyu.aop.service;

import com.daiyu.aop.controller.request.ParamRequest;
import com.daiyu.aop.controller.response.ResultResponse;
import org.springframework.stereotype.Service;

/**
 * created by dyx on 2021/11/24
 */
@Service
public class AopTestServiceImpl implements AopTestService{

    @Override
    public Integer getResult(ParamRequest request) {

        ResultResponse response = new ResultResponse();
        response.setCode(200);
        response.setMessage("初始数据");
        response.setData("123");
        return response.getCode();
    }
}
