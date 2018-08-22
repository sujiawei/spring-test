package com.sujiawei.java.annotation;

import java.lang.reflect.Method;

public class TestTool {

    public static void main(String[] args) {
        NoBug noBug = new NoBug();

        Class clazz = noBug.getClass();

        Method[] methods = clazz.getDeclaredMethods();

        StringBuilder log = new StringBuilder();

        int errorNum = 0;

        for (Method method : methods) {
            if (method.isAnnotationPresent(JianCha.class)) {
                try {
                    method.setAccessible(true);
                    method.invoke(noBug, null);
                } catch (Exception e) {
//                    e.printStackTrace();
                    errorNum++;
                    log.append(method.getName());
                    log.append(" ");
                    log.append("has error:");
                    log.append("\n\r caused by ");
                    log.append(e.getCause().getClass().getSimpleName());
                    log.append("\n\r");
                    log.append(e.getCause().getMessage());
                    log.append("\n\r");
                }
            }
        }

        log.append(clazz.getSimpleName());
        log.append(" has ");
        log.append(errorNum);
        log.append(" error.");

        System.out.println(log.toString());
    }
}
