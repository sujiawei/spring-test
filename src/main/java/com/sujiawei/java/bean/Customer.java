package com.sujiawei.java.bean;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Customer implements Serializable {

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    private Person person;

    private int custId;

    private String name;

    private int age;

    private List<Object> lists;
    private Set<Object> sets;
    private Map<Object, Object> maps;

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }

    public Set<Object> getSets() {
        return sets;
    }

    public void setSets(Set<Object> sets) {
        this.sets = sets;
    }

    public Map<Object, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<Object, Object> maps) {
        this.maps = maps;
    }

    public Properties getPros() {
        return pros;
    }

    public void setPros(Properties pros) {
        this.pros = pros;
    }

    private Properties pros;

    public List getLists2() {
        return lists2;
    }

    public void setLists2(List lists2) {
        this.lists2 = lists2;
    }

    private List lists2;

    public Set getSets2() {
        return sets2;
    }

    public void setSets2(Set sets2) {
        this.sets2 = sets2;
    }

    private Set sets2;


    public Customer() {

    }

    public Customer(int custId, String name, int age) {
        this.custId = custId;
        this.name = name;
        this.age = age;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
