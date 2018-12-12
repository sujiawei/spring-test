package com.sujiawei.java.bean;

import com.sujiawei.java.annotation.CheckEmpty;

@CheckEmpty
public class User {

    public Integer id;

    public String name;

    public Integer getBirthday() {
        return birthday;
    }

    public void setBirthday(Integer birthday) {
        this.birthday = birthday;
    }

    public Integer birthday;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
