package com.daiyu.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

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
    }
}
