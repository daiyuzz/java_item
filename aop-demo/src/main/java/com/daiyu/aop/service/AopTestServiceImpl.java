package com.daiyu.aop.service;

import com.daiyu.aop.controller.request.ParamRequest;
import com.daiyu.aop.controller.response.ResultResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * created by dyx on 2021/11/24
 */
@Service
public class AopTestServiceImpl implements AopTestService{

    @Override
    public List<ResultResponse> getResult(ParamRequest request) {
        List<ResultResponse> resultList = new ArrayList<>();
        ResultResponse response = new ResultResponse();
        response.setCode(200);
        response.setMessage("初始数据");
        response.setData("123");
        ResultResponse response2 = new ResultResponse();
        response2.setCode(500);
        response2.setMessage("123");
        response2.setData("123");
        resultList.add(response);
        resultList.add(response2);
        return resultList;
    }

    @Override
    public Integer getResult(Integer age, String name) {
        ResultResponse response = new ResultResponse();
        response.setCode(200);
        response.setMessage("初始数据");
        response.setData("123");
        return response.getCode();
    }
}
