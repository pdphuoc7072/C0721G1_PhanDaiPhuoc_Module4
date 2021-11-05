package com.codegym.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
public class AllLogAspect {
    int count = 0;

    @Pointcut("within(com.codegym.controller..*)")
    public void allMethodPointCut(){}

    @Around("allMethodPointCut()")
    public Object aroundCallMethod (ProceedingJoinPoint proceedingJoinPoint) {
        count++;
        System.out.println("Before method time: " + LocalDateTime.now());

        Object value = null;

        try {
            value = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            System.out.println("Throwing method time: " + LocalDateTime.now());
            throwable.printStackTrace();
        }

        System.out.println("After method time: " + LocalDateTime.now() + " , Return value: " + value +
                " , Số lượng ghé thăm: " + count);

        return value;
    }
}
