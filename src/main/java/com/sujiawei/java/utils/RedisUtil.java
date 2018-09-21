package com.sujiawei.java.utils;

import java.util.HashMap;
import java.util.Map;

public class RedisUtil {

    private static Map<String, Object> map = new HashMap<>();

    public static Object get(String key) {
        return map.get(key);
    }

    public static void set(String key, Object value) {
        map.put(key, value);
    }

    public static void del(String key) {
        map.remove(key);
    }

    public static Object get(String methodName, String params) {
        String key = methodName + ":" + params;
        return map.get(key);
    }
}
