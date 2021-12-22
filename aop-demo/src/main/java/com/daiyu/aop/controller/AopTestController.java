package com.daiyu.aop.controller;

import com.daiyu.aop.controller.request.ParamRequest;
import com.daiyu.aop.controller.response.ResultResponse;
import com.daiyu.aop.service.AopTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * created by dyx on 2021/11/24
 */
@RestController
@RequestMapping(value = "test")
public class AopTestController {

    @Autowired
    private AopTestService service;

    @GetMapping("/result")
    public Integer getResult(ParamRequest request){
        return service.getResult(request);
    }


    @GetMapping("/result2")
    public Integer getParam(
            @RequestParam("age") Integer age,
            @RequestParam("name") String name
     ){
        return service.getResult(age, name);
    }

}
