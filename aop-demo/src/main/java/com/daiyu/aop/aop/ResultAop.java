package com.daiyu.aop.aop;

import com.daiyu.aop.controller.response.ResultResponse;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.xml.transform.Source;
import java.util.List;


/**
 * created by dyx on 2021/11/24
 */
@Aspect
@Component
public class ResultAop {

    @AfterReturning(value = "execution(* com.daiyu.aop.controller.AopTestController.getResult(..))", returning = "keys")
    public void change(JoinPoint joinPoint, Object keys) {
        System.out.println("这是一个后置通知.." + keys);
        List<ResultResponse> results = (List<ResultResponse>) keys;
        results.forEach(result -> {
            System.out.println(result);
        });

    }


    @AfterReturning(value = "execution(* com.daiyu.aop.controller.AopTestController.getParam(..))", returning = "keys")
    public void getParam(JoinPoint joinPoint, Object keys) {
        System.out.println("这是一个后置通知.." + keys);
        if (keys instanceof Integer) {
            Integer key = (Integer) keys;
            System.out.println(key);
        }
        // 获取传入参数
        Object[] args = joinPoint.getArgs();
        for (Object obj : args){
            if (obj instanceof Integer){
                System.out.println(obj);
                return;
            }
        }
    }

}
