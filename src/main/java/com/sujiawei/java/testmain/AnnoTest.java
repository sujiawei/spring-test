package com.sujiawei.java.testmain;

import com.sujiawei.java.annotation.CheckEmpty;
import com.sujiawei.java.services.impl.UserServiceImpl;

import java.lang.reflect.Method;

public class AnnoTest {

    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        Class clazz = userService.getClass();

        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            CheckEmpty checkEmpty = method.getAnnotation(CheckEmpty.class);
            System.out.println(checkEmpty.fields());
        }
    }
}
