package com.daiyu.aop.aop;

import com.daiyu.aop.controller.request.ParamRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * created by dyx on 2021/11/24
 */
@Aspect
@Component
public class ResultAop {

    @AfterReturning(value = "execution(* com.daiyu.aop.controller.AopTestController.getResult(..))", returning = "keys")
    public void change(JoinPoint joinPoint, Object keys) {
        System.out.println("这是一个后置通知.." + keys);
        if (keys instanceof Integer) {
            Integer key = (Integer) keys;
            System.out.println(key);
        }
        // 获取传入参数
        Object[] args = joinPoint.getArgs();
        for (Object obj : args) {
            if (!Objects.isNull(obj)) {
                ParamRequest request = (ParamRequest) obj;
                Integer age = request.getAge();
                System.out.println(age);
            }
        }
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
