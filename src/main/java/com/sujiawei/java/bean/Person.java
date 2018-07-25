package com.sujiawei.java.bean;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.io.Serializable;
import java.util.AbstractList;

public class Person implements Serializable {

    @Autowired(required = false)
    @Qualifier("AbilityBean1")
    private Ability ability;

    private String name;

    private String address;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void say() {
        System.out.println("I'm a person");
    }

    public Ability getAbility() {
        return ability;
    }

    public String toString() {
        return  JSON.toJSONString(this);
    }
}
