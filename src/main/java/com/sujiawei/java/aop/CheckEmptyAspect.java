package com.sujiawei.java.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CheckEmptyAspect {

    @Before("execution(* com.sujiawei.java..*.*(..)) && @annotation(com.sujiawei.java.annotation.TxManagerAnnotation)")
    public void beforeAdvice(JoinPoint joinPoint) {
    }
}