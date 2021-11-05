package com.codegym.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
public class LogAspect {

    @Pointcut("within(com.codegym.controller.BookBorrowController*)")
    public void allMethodPointCut() {
    }

    @AfterReturning("allMethodPointCut()")
    public void afterCallMethod(JoinPoint joinPoint) {
        System.out.println("After call method: " + joinPoint.getSignature().getName() + " , Time: " + LocalDateTime.now());
    }
}
