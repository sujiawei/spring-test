package com.sujiawei.java.bean;

import com.alibaba.fastjson.JSON;
import com.sujiawei.java.common.Mandatory;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component("workerBean")
public class Worker implements Serializable {

    private Person person;

    @Value("#{addressBean}")
    private Address address;

    @Value("#{addressBean.country}")
    private String country;

    @Value("#{addressBean.getFullAddress('sjw')}")
    private String fullAddress;

    @Value("#{'sujiawei'.toUpperCase()}")
    private String name;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Value("#{addressBean.getSpecialPrice()}")
    private double amount;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Worker(Person person) {
        this.person = person;
    }

    public Worker() {

    }

    @Mandatory
    public void setPerson(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public String toString() {
        return JSON.toJSONString(this);
    }
}
