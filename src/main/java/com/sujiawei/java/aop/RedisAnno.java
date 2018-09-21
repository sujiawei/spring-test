package com.sujiawei.java.aop;

import com.sujiawei.java.annotation.RedisTest;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class RedisAnno implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        RedisTest redisTest = methodInvocation.getMethod().getAnnotation(RedisTest.class);
        String userType = redisTest.useType();
        Object result = methodInvocation.proceed();
        if ("get".equals(userType)) {
            System.out.println("get redis");
        } else if ("set".equals(userType)) {

            System.out.println("set redis");
        } else if ("del".equals(userType)) {

            System.out.println("del redis");
        }
        return null;
    }
}
