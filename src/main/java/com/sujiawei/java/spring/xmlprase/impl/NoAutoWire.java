package com.sujiawei.java.spring.xmlprase.impl;

import com.sujiawei.java.spring.xmlprase.AutoWire;

public class NoAutoWire implements AutoWire {

    private String value;

    public NoAutoWire(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
