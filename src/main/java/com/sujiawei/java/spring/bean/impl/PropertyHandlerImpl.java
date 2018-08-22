package com.sujiawei.java.spring.bean.impl;

import com.sujiawei.java.bean.Department;
import com.sujiawei.java.spring.bean.PropertyHandler;
import com.sujiawei.java.utils.StringUtil;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class PropertyHandlerImpl implements PropertyHandler {

    @Override
    public Map<String, Method> getSetterMethodsMap(Object obj) {
        Map<String, Method> setterMethodsMap = new HashMap<>();

        try {
            Field[] fields = obj.getClass().getDeclaredFields();
            for (Field field : fields) {
                String methodName = "set" + StringUtil.upperCase(field.getName());
                Method method = obj.getClass().getMethod(methodName, field.getType());
                setterMethodsMap.put(field.getName(), method);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return setterMethodsMap;
    }

    @Override
    public void executeMethod(Object obj, Object bean, Method method) {
        try {
            method.invoke(obj, bean);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setProperties(Object obj, Map<String, Object> propertiesMap) {

        propertiesMap.forEach((key, value) -> {
            try {
                String methodName = "set" + StringUtil.upperCase(key);
                Class[] classes = getMethodParamTypes(obj, methodName);
                Method method = obj.getClass().getMethod(methodName, classes);
                Object val = getValue(classes[0], value);
                method.invoke(obj, val);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private Class[] getMethodParamTypes(Object obj, String methodName) throws ClassNotFoundException {
        Class[] paramTypes = null;
        Method[] methods = obj.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (methodName.equals(method.getName())) {
                Class[] params = method.getParameterTypes();
                paramTypes = new Class[params.length];
                for (int i = 0; i < params.length; i++) {
                    paramTypes[i] = Class.forName(params[i].getName());
                }
                break;
            }
        }
        return paramTypes;
    }

    private Object getValue(Class paramType, Object value) {
        switch (paramType.getName()) {
            case "java.lang.Integer":
                return Integer.parseInt(value.toString());
            case "java.lang.Long":
                return Long.parseLong(value.toString());
            default:
                return value.toString();
        }
    }


    public static void main(String[] args) throws Exception{
        Department department = new Department();
        Field[] fields = department.getClass().getDeclaredFields();
        System.out.println(fields.toString());
    }
}
