package com.sujiawei.java.aop;

import com.sujiawei.java.annotation.CheckEmpty;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Service;

@Service
public class CheckEmptyAnno implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {


        CheckEmpty checkEmpty = methodInvocation.getMethod().getAnnotation(CheckEmpty.class);
        String fields = checkEmpty.fields();

        Object[] arguments = methodInvocation.getArguments();
        if ("".equals(fields)) {
            System.out.println("+++++++");
        } else {

            System.out.println("-------");
        }

        Object result = methodInvocation.proceed();
        return null;
    }
}