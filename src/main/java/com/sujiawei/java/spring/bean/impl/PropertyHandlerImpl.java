package com.sujiawei.java.spring.bean.impl;

import com.sujiawei.java.spring.bean.PropertyHandler;

import java.lang.reflect.Method;
import java.util.Map;

public class PropertyHandlerImpl implements PropertyHandler {

    @Override
    public Map<String, Method> getSetterMethodsMap(Object obj) {
        return null;
    }

    @Override
    public void executeMethod(Object obj, Object bean, Method method) {

    }

    @Override
    public void setProperties(Object obj, Map<String, Object> propertiesMap) {

    }
}
