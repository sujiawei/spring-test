package com.sujiawei.java.spring.xmlprase.impl;

import com.sujiawei.java.spring.xmlprase.AutoWire;

public class ByNameAutoWire implements AutoWire {

    private String value;

    public ByNameAutoWire(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
