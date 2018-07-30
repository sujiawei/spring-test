package com.sujiawei.java.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("addressBean")
public class Address {

    @Value("GaoDeng, QiongShang")
    private String street;

    @Value("456150")
    private int postcode;

    @Value("CN")
    private String country;

    public double getSpecialPrice() {
        return 199.09;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFullAddress(String prefix) {
        return prefix + " : " + street + " : " + postcode + " : " + country;
    }
}
