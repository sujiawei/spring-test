package com.sujiawei.java.bean;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Website {

    @Value("sujiawei")
    private String name;

    @Value("http://www.sujiawei.com")
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void printName() {
        System.out.println(" websit name : " + name);
    }

    public void printUrl() {
        System.out.println(" websit url : " + url);
    }

    public void printThrowException() {
        throw new IllegalArgumentException();
    }

    public String toString() {
        return JSON.toJSONString(this);
    }
}
