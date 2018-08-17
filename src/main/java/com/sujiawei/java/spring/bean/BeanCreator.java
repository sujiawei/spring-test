package com.sujiawei.java.spring.bean;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

public interface BeanCreator {

    Object createBeanUseDefaultConstruct(String className);

    Object createBeanUseDefineConstruce(String className, List<Object> args);

    Map<String, Method> getSetterMethodsMap(Object obj);

    void executeMethod(Object object, Object argBean, Method method);
}
