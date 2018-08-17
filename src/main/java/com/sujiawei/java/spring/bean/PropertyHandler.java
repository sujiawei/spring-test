package com.sujiawei.java.spring.bean;

import java.lang.reflect.Method;
import java.util.Map;

public interface PropertyHandler {

    Map<String, Method> getSetterMethodsMap(Object obj);

    void executeMethod(Object obj, Object bean, Method method);

    void setProperties(Object obj, Map<String, Object> propertiesMap);
}
